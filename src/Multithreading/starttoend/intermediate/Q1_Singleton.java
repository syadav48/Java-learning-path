package Multithreading.starttoend.intermediate;

public class Q1_Singleton {
    private static int number = 0;
    private static synchronized void increment(){
        number++;
    }
    private static synchronized int getCount(){
       return number;
    }
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            while (true) {
                increment();

            }
        });
        Thread threadB = new Thread(() -> {
            while (true) {
                increment();
            }
        });
        threadA.start();
        threadB.start();
        System.out.println("count:" + getCount());
    }
}

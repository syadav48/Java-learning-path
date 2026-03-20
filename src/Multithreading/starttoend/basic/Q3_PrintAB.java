package Multithreading.starttoend.basic;

public class Q3_PrintAB {
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            while (true){
                System.out.println("A");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


        });
        Thread threadB = new Thread(() -> {
            while (true){
                System.out.println("B");
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


        });
        threadA.start();
        threadB.start();
    }
}

package Multithreading.starttoend.intermediate;

public class Q2_PrintNumber {
    private static final Object lock = new Object();
    private static int number = 1;
    private static final int N = 30;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lock){
                    while (number <= N && number % 3 != 0){
                        waitSafely();
                    }
                    if (number > N) break;
                    System.out.println("Div by three:" + number);
                    number++;
                    lock.notifyAll();
                }

            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lock){
                    while (number <= N && number % 5 != 0){
                        waitSafely();
                    }
                    if (number > N) break;
                    System.out.println("Div by five:" + number);
                    number++;
                    lock.notifyAll();
                }


            }
        });
        Thread thread3 = new Thread(() -> {
            while (true) {
                synchronized (lock){
                    while (number <= N && (number % 3 == 0 || number % 5 == 0)){
                        waitSafely();
                    }
                    if (number > N) break;
                    System.out.println("Others:" + number);
                    number++;
                    lock.notifyAll();
                }


            }
        });
        thread1.start();
        thread2.start();
        thread3.start();

    }
    private static void waitSafely(){
        try{
            lock.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

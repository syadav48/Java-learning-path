package LTMClinet.multiThreading.level2;

public class PrintEvenOdd {
    private static final Object lock = new Object();
    private static boolean numberTurn = true;
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lock){
                    while (!numberTurn){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(i + " ");
                    numberTurn = false;
                    lock.notifyAll();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (char c = 'a'; c <= 'e'; c++) {
                synchronized (lock){
                    while (numberTurn){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(c + " ");
                    numberTurn = true;
                    lock.notifyAll();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}

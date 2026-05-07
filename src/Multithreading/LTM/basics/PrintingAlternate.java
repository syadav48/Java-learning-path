package Multithreading.LTM.basics;

public class PrintingAlternate {
    private static final Object lock = new Object();
    private static boolean show = true;
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lock){
                    while (!show){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(i);
                    show = false;
                    lock.notify();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (char c = 'a'; c < 'a' + 5; c++) {
                synchronized (lock){
                    while (show){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(c);
                    show = true;
                    lock.notify();
                }
            }

        });
        thread1.start();
        thread2.start();

    }
}

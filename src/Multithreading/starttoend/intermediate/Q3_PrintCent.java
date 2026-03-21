package Multithreading.starttoend.intermediate;

public class Q3_PrintCent {
    public static int num = 0;
    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    for (int i = 1; i < 34; i++) {
                        num++;
                        System.out.println("till 1:" + i);
                    }
                    if (num > 33) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        lock.notifyAll();
                    }

                }
            }
        });
        Thread threadB = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    for (int i = 34; i < 67; i++) {
                        num++;
                        System.out.println("till 2:" + i);
                    }
                    if (num > 66) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        lock.notifyAll();
                    }

                }
            }
        });
        Thread threadC = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    for (int i = 67; i < 101; i++) {
                        num++;
                        System.out.println("till 3:" + i);
                    }
                    if (num > 101) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        lock.notifyAll();
                    }

                }
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }
}

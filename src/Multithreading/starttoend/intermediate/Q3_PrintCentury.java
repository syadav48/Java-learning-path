package Multithreading.starttoend.intermediate;
public class Q3_PrintCentury {

    private static final Object lock = new Object();
    private static int number = 1;
    private static final int N = 100;

    public static void main(String[] args) {

        Thread threadA = new Thread(() -> { // 1–33
            while (true) {
                synchronized (lock) {

                    while (number <= N && number > 33) {
                        waitSafely();
                    }

                    if (number > N) break;

                    System.out.println("A: " + number);
                    number++;

                    lock.notifyAll();
                }
            }
        });

        Thread threadB = new Thread(() -> { // 34–66
            while (true) {
                synchronized (lock) {

                    while (number <= N && (number <= 33 || number > 66)) {
                        waitSafely();
                    }

                    if (number > N) break;

                    System.out.println("B: " + number);
                    number++;

                    lock.notifyAll();
                }
            }
        });

        Thread threadC = new Thread(() -> { // 67–100
            while (true) {
                synchronized (lock) {

                    while (number <= N && number <= 66) {
                        waitSafely();
                    }

                    if (number > N) break;

                    System.out.println("C: " + number);
                    number++;

                    lock.notifyAll();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }

    private static void waitSafely() {
        try {
            lock.wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

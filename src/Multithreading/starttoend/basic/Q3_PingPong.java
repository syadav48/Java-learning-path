package Multithreading.starttoend.basic;

public class Q3_PingPong {
    private static final Object lock = new Object();
    private static  boolean isPingTurn = true;
    public static void main(String[] args) {
        Thread pingThread = new Thread(() -> {
            while (true){
                synchronized (lock){
                    while (!isPingTurn){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Ping");
                    isPingTurn = false;

                    lock.notify();
                }

            }


        });

        Thread pongThread = new Thread(() -> {
            while (true) {
                synchronized (lock) {

                    while (isPingTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("Pong");
                    isPingTurn = true;

                    lock.notify();
                }
            }
        });

        pingThread.start();
        pongThread.start();

    }
}

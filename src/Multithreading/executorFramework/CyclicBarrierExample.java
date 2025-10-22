package Multithreading.executorFramework;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int totalThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(totalThreads,
                () -> System.out.println("All threads reached the barrier. Proceeding together..."));

        for (int i = 1; i <= totalThreads; i++) {
            final int threadId = i;
            new Thread(() -> {
                try {
                    System.out.println("Thread " + threadId + " working...");
                    Thread.sleep(1000 * threadId);
                    System.out.println("Thread " + threadId + " waiting at barrier...");
                    barrier.await(); // wait for others
                    System.out.println("Thread " + threadId + " passed the barrier.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

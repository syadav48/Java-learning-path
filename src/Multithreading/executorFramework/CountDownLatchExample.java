package Multithreading.executorFramework;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int totalThreads = 3;
        CountDownLatch latch = new CountDownLatch(totalThreads);

        for (int i = 1; i <= totalThreads; i++) {
            final int threadId = i;
            new Thread(() -> {
                System.out.println("Worker " + threadId + " started.");
                try {
                    Thread.sleep(2000 * threadId); // simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Worker " + threadId + " finished.");
                latch.countDown(); // reduce the count
            }).start();
        }

        System.out.println("Main thread waiting for workers to finish...");
        latch.await(); // wait until count reaches 0
        System.out.println("All workers finished. Main thread continues...");
    }
}

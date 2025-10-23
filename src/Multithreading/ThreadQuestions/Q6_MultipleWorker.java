package Multithreading.ThreadQuestions;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Q6_MultipleWorker {
    public static void main(String[] args) {
        // Shared Runnable task - same task executed by multiple threads
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " started executing the task");

                for (int i = 0; i < 5; i++) {
                    System.out.println(threadName + " - Task iteration: " + i);
                    try {
                        Thread.sleep(500); // Simulate some work
                    } catch (InterruptedException e) {
                        System.out.println(threadName + " was interrupted");
                        return;
                    }
                }

                System.out.println(threadName + " completed the task");
            }
        };

        // Create a fixed thread pool with 3 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        System.out.println("Created thread pool with 3 worker threads");

        // Submit the same Runnable task to multiple worker threads
        System.out.println("\nSubmitting the same Runnable task to 3 worker threads...");

        Future<?> future1 = executor.submit(runnable);
        Future<?> future2 = executor.submit(runnable);
        Future<?> future3 = executor.submit(runnable);

        System.out.println("All tasks submitted to executor service");

        // Wait for all tasks to complete using Future.get()
        try {
            System.out.println("\nWaiting for tasks to complete...");

            // Future.get() blocks until the task completes
            Object result1 = future1.get();
            System.out.println("Task 1 completed with result: " + result1);

            Object result2 = future2.get();
            System.out.println("Task 2 completed with result: " + result2);

            Object result3 = future3.get();
            System.out.println("Task 3 completed with result: " + result3);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Important: shutdown the executor
            executor.shutdown();
            System.out.println("\nExecutor service shutdown");
        }

        System.out.println("Main thread finished");
    }
}

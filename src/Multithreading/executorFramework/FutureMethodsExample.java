package Multithreading.executorFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureMethodsExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Working " + i);
                Thread.sleep(100);
            }
            return 10;
        };

        Future<Integer> future = executor.submit(task);

        Thread.sleep(1200);
        System.out.println("Is Done? " + future.isDone());

        // Cancel example
        boolean cancelled = future.cancel(true);
        System.out.println("Cancelled: " + cancelled);
        System.out.println("Is Cancelled? " + future.isCancelled());

        executor.shutdown();
    }
}

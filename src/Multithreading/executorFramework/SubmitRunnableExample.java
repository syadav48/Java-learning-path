package Multithreading.executorFramework;

import java.util.concurrent.*;

public class SubmitRunnableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable task1 = () -> System.out.println("Runnable executed by " + Thread.currentThread().getName());
        Callable<Integer> task2 = () -> {
            System.out.println("Calculating Sum...");
            Thread.sleep(1000);
            return 42;
        };
        Future<?> future1 = executorService.submit(task1);
        Future<Integer> future2 = executorService.submit(task2);
        System.out.println("Runnable Task Submitted");
        System.out.println("Callable Task Submitted" + future2.get());
        executorService.shutdown();
    }
}

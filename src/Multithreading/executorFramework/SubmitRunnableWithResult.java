package Multithreading.executorFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitRunnableWithResult {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Runnable task = () -> System.out.println("Running a task...");
        Future<String> future = executor.submit(task, "Task Completed");

        System.out.println(future.get());
        // Will return "Task Completed"

        executor.shutdown();
    }


}

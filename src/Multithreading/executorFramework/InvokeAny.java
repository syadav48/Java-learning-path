package Multithreading.executorFramework;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAny {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = List.of(
                () -> { Thread.sleep(2000); return "Task 1"; },
                () -> { Thread.sleep(1000); return "Task 2"; },
                () -> { Thread.sleep(1500); return "Task 3"; }
        );
        String result = executor.invokeAny(tasks);
        System.out.println("First Completed:" + result);
        executor.shutdown();
    }
}

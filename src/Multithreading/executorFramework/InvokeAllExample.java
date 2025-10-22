package Multithreading.executorFramework;

import java.util.List;
import java.util.concurrent.*;

public class InvokeAllExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = List.of(
                () -> {Thread.sleep(1000); return "Task 1 done";},
                () -> {Thread.sleep(2000); return "Task 2 done";},
                () -> {Thread.sleep(500); return "Task 3 done";}
        );
        List<Future<String>> results = executor.invokeAll(tasks);

        for(Future<String> f: results){
            System.out.println(f.get());
        }
        executor.shutdown();
    }
}

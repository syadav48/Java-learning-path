package Multithreading.executorFramework;

import java.util.concurrent.*;

public class SubmitCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            System.out.println("Calculating sum..");
            Thread.sleep(1000);
            return 42;
        };
        Future<Integer> future = executor.submit(task);
        System.out.println("Result:" + future.get());

        executor.shutdown();
    }
}

package Multithreading.starttoend.basic;

import java.util.concurrent.*;

public class CompletableFutureTest {
    public static void main(String[] args) {
        Callable<String> callable = () -> "Hello";
        ExecutorService service = Executors.newSingleThreadExecutor();
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello", service)
                .thenApply((str) -> str + " World");
        System.out.println(completableFuture.join());
        service.shutdown();
    }
}

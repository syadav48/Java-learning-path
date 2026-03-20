package Multithreading.starttoend.basic;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompleteableFutureAdd {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> 10, service);
        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> 20, service);
        CompletableFuture<Integer> completableFuture = task1.thenCombine(task2, (a, b) -> a + b);
        System.out.println(completableFuture.join());
        service.shutdown();
    }
}

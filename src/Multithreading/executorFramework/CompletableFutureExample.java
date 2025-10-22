package Multithreading.executorFramework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> fetchData = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching data from API... " + Thread.currentThread().getName());
            sleep(1000);
            return "Data from API";
        });

        // ✅ 2. thenApply() — transform the result
        CompletableFuture<String> processData = fetchData.thenApply(data -> {
            System.out.println("Processing data... " + Thread.currentThread().getName());
            return data.toUpperCase();
        });

        // ✅ 3. thenAccept() — consume result (no return)
        CompletableFuture<Void> displayData = processData.thenAccept(result -> {
            System.out.println("Displaying result: " + result);
        });

        // ✅ 4. thenRun() — run task after completion (doesn’t depend on result)
        CompletableFuture<Void> finalTask = displayData.thenRun(() ->
                System.out.println("All tasks done! Cleaning up..."));

        // ✅ 5. combine two async tasks using thenCombine()
        CompletableFuture<Integer> compute1 = CompletableFuture.supplyAsync(() -> {
            sleep(500);
            return 10;
        });

        CompletableFuture<Integer> compute2 = CompletableFuture.supplyAsync(() -> {
            sleep(700);
            return 20;
        });

        CompletableFuture<Integer> combined = compute1.thenCombine(compute2, (a, b) -> a + b);
        System.out.println("Combined result: " + combined.get());

        // ✅ 6. handle() — handle both normal and exceptional cases
        CompletableFuture<String> handleExample = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Something went wrong!");
            return "OK";
        }).handle((result, ex) -> {
            if (ex != null) return "Recovered from error: " + ex.getMessage();
            return result;
        });

        System.out.println(handleExample.get());

        // ✅ 7. exceptionally() — only handles exceptions
        CompletableFuture<Object> exceptionExample = CompletableFuture.supplyAsync(() -> {
            throw new IllegalStateException("DB connection failed");
        }).exceptionally(ex -> "Default fallback value due to: " + ex.getMessage());

        System.out.println(exceptionExample.get());

        // ✅ 8. allOf() — wait for all futures to complete
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            sleep(300);
            return "Task 1";
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            sleep(400);
            return "Task 2";
        });

        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> {
            sleep(200);
            return "Task 3";
        });

        CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3)
                .thenRun(() -> System.out.println("All tasks completed!"));
        all.join(); // Waits for all to complete

        System.out.println(f1.get() + ", " + f2.get() + ", " + f3.get());

        // ✅ 9. anyOf() — completes when *any one* future completes
        CompletableFuture<Object> any = CompletableFuture.anyOf(f1, f2, f3);
        System.out.println("First completed: " + any.get());

        // ✅ 10. Using join() — similar to get() but unchecked
        CompletableFuture<String> joinExample = CompletableFuture.supplyAsync(() -> "Hello using join!");
        System.out.println(joinExample.join());

        // ✅ 11. Using custom Executor (instead of ForkJoinPool)
        ExecutorService customExecutor = Executors.newFixedThreadPool(2);
        CompletableFuture<String> customExecExample =
                CompletableFuture.supplyAsync(() -> "Executed on custom thread", customExecutor);

        System.out.println(customExecExample.get());
        customExecutor.shutdown();
    }

    private static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}

    }
}

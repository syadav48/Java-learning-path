package Multithreading.starttoend.basic;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FutureGet {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Callable<Integer> callable = () -> {
            for (int i = 1; i < 1155551; i++) {
                atomicInteger.addAndGet(i);
            }
            return atomicInteger.get();
        };
        Future<Integer> submitted = service.submit(callable);
        System.out.println(submitted.get());
        service.shutdown();
    }
}

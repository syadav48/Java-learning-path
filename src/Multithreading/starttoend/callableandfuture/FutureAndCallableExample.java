package Multithreading.starttoend.callableandfuture;

import java.util.concurrent.*;

public class FutureAndCallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            System.out.println("Entered Callable");
            Thread.sleep(2000);
            return "Hello From Callable";
        };
        System.out.println("Submitting Callble");
        Future<String> submit = executorService.submit(callable);
        System.out.println("Do something else while callable is getting executed");

        System.out.println("Retrieve the result of the future");

        String res = submit.get();
        System.out.println(res);
        executorService.shutdown();

    }
}

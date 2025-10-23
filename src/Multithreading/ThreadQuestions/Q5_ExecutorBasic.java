package Multithreading.ThreadQuestions;

import java.util.concurrent.*;

public class Q5_ExecutorBasic {
    public static void main(String[] args) {
        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        Callable<Integer> sumIntegers = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i < 100; i++) {

                    sum += i;
                }
                return sum;
            };
        };
        Future<Integer> integerFuture = executor1.submit(sumIntegers);
        try {
            System.out.println("Integer is:" + integerFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor1.shutdown();
        System.out.println("Main is shutting down");

    }
}

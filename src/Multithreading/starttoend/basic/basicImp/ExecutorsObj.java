package Multithreading.starttoend.basic.basicImp;
import java.util.concurrent.*;

public class ExecutorsObj {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<Integer> callable = () -> {
            int count = 0;
            for (int i = 0; i < 6; i++) {
                count += i;
                System.out.println(Thread.currentThread().getName());
            }
            return count;
        };
        executorService.submit(callable);
        executorService.submit(callable);
        executorService.submit(callable);
        executorService.submit(callable);
        Future<Integer> future = executorService.submit(callable);
        Integer integer = future.get();
        System.out.println(integer);
        executorService.shutdown();

    }
}

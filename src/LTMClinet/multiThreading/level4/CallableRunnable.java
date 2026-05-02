package LTMClinet.multiThreading.level4;

import java.util.concurrent.*;

public class CallableRunnable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> {
            System.out.println(Thread.currentThread().getName());
            return "Callable return";
        };
        Future<String> submit = service.submit(callable);
        String s = submit.get();
        System.out.println(s);

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("taks:" + i);
            }
        };
        service.submit(runnable);
        service.shutdown();
    }
}

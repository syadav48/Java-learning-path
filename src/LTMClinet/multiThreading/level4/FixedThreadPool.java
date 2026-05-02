package LTMClinet.multiThreading.level4;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            service.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " :" + "task:" + taskId);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        service.shutdown();
        System.out.println("All services submitted");
    }
}

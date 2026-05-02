package LTMClinet.multiThreading.level4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Runnable in every in 2 secs");
            }
        };
        service.schedule(runnable, 1000, TimeUnit.MILLISECONDS);
        service.shutdown();
    }
}

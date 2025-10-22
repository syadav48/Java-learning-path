package Multithreading.executorFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FixedRateExample {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("FixedRate Task: " + System.currentTimeMillis());

        scheduler.scheduleAtFixedRate(task, 2, 3, TimeUnit.SECONDS); // initial delay 2s, repeat every 3s

        Thread.sleep(10000);
        scheduler.shutdown();
    }
}

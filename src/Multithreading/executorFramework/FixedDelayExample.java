package Multithreading.executorFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FixedDelayExample {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            System.out.println("FixedDelay Task: " + System.currentTimeMillis());
            try {
                Thread.sleep(2000); // simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        scheduler.scheduleWithFixedDelay(task, 1, 3, TimeUnit.SECONDS); // start after 1s, wait 3s after finish

        Thread.sleep(15000);
        scheduler.shutdown();
    }
}

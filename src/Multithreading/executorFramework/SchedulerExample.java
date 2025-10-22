package Multithreading.executorFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerExample {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable task = () -> System.out.println("Tasks executed after delay:" + System.currentTimeMillis());
        System.out.println("Task Scheduled at :" + System.currentTimeMillis());
        scheduler.schedule(task, 3, TimeUnit.SECONDS);

        Thread.sleep(5000);
        scheduler.shutdown();
    }
}

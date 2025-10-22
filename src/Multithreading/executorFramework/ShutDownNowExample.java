package Multithreading.executorFramework;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutDownNowExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable task = () -> {
            try {
                Thread.sleep(5000);
                System.out.println("Task finished");
            } catch (InterruptedException e) {
                System.out.println("Task interrupted!");
            }
        };

        executor.submit(task);
        List<Runnable> pending = executor.shutdownNow();

        System.out.println("Forced shutdown! Pending tasks: " + pending.size());
        System.out.println("isShutdown: " + executor.isShutdown());
        System.out.println("isTerminated: " + executor.isTerminated());
    }
}

package Multithreading.starttoend.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScheduledExecutor {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Runnable runnable = () -> {
            while (true){
                System.out.println("Hello");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        };
        service.submit(runnable);
        service.shutdown();
    }
}

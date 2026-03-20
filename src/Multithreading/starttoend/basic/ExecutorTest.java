package Multithreading.starttoend.basic;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        service.submit(runnable);
        service.submit(runnable);
        service.submit(runnable);
        service.submit(runnable);
        service.submit(runnable);
        service.shutdown();
    }
}

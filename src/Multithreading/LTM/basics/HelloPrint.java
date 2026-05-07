package Multithreading.LTM.basics;

import java.util.concurrent.*;

public class HelloPrint {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "Printing Thread");
            }

        }, "t0");
        thread.start();
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+ "Printing Thread");
            }
        };
        Thread thread1 = new Thread(runnable, "t1");
        thread1.start();
        Callable<String> callable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+ "Printing Thread");
            }
            return "Callable Thread instantiating";
        };
        Future<String> submit = service.submit(callable);
        String s = submit.get();
        System.out.println(s);
    }
}

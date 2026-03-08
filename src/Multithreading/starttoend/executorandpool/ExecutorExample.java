package Multithreading.starttoend.executorandpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        System.out.println("Inside: " + Thread.currentThread().getName());
        System.out.println("Creating Executor Service...");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("Calling Runnable");
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        System.out.println("Submit the task specified by the runnable to the executor service.");

        executorService.submit(runnable);
        //If you run the above program, you will notice that the program never exits, because,
        // the executor service keeps listening for new tasks until we shut it down explicitly.

        System.out.println("Shutting down the executor");
        executorService.shutdown();


    }
}

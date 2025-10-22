package Multithreading.executorFramework;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadedExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(() -> 42);
        System.out.println(future.get());
        //callable: if you want to return something:
        //runnable: nothing to return:
        if(future.isDone()){
            System.out.println("Task is done");
        }
        executorService.shutdown();

    }
}

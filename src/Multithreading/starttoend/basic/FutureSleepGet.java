package Multithreading.starttoend.basic;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FutureSleepGet {
   public static void main(String[] args) throws ExecutionException, InterruptedException {
       ExecutorService service = Executors.newSingleThreadExecutor();
       AtomicInteger integer = new AtomicInteger();
       Callable<Integer> callable = () -> {
           for (int i = 0; i < 10000000; i++) {
               System.out.println("Task started...");
               Thread.sleep(3000);  // simulate long task
               System.out.println("Task completed...");
               integer.addAndGet(i);
           }
           return integer.get();
       };
       Future<Integer> future = service.submit(callable);

       while (!future.isDone()) {
           System.out.println("Still working...");
           Thread.sleep(500); // avoid busy waiting
       }

       System.out.println("Result: " + future.get());

       service.shutdown();

   }
}

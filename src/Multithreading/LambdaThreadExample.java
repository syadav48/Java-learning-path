package Multithreading;

public class LambdaThreadExample  {
    public static void main(String[] args) {
        // Creating thread using lambda (Runnable functional interface)
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - Count: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted!");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - Message: Hello!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " interrupted!");
                }
            }
        });

        t1.setName("Worker-1");
        t2.setName("Worker-2");

        // Start both threads
        t1.start();
        t2.start();
    }
}

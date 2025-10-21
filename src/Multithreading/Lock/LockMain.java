package Multithreading.Lock;

public class LockMain {
    public static void main(String[] args) throws InterruptedException {
        //BankAccount bankAccount = new BankAccount();
        //ReentrantLockMain sbi = new ReentrantLockMain();
        UnfairLockExample unfair = new UnfairLockExample();
        Runnable task = new Runnable() {
            @Override
            public void run() {
               unfair.accessResource();
            }
        };
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        Thread t3 = new Thread(task, "Thread 3");
        t1.start();
        Thread.sleep(30);
        t2.start();
        Thread.sleep(30);
        t3.start();
    }
}

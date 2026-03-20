package Multithreading.starttoend.basic;

import java.util.concurrent.locks.ReentrantLock;

public class CounterReentrantLock {
    private static int count = 0;
    private static final ReentrantLock lock = new ReentrantLock();
    public static void increment(){
        lock.lock();
        try{
            count++;
        } finally {
            lock.unlock(); //must be in finally
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Final count:" + count);
    }
}

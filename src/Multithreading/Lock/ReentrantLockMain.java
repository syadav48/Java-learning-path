package Multithreading.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMain {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();
    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + "attempting to withdraw" + amount);
        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if(balance >= amount){
                    try {
                        System.out.println(Thread.currentThread().getName() + "proceeding with withdrawls");
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + "complete withdrawl. Remaining Balance:" + balance);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
        ;
                } else {
                    System.out.println(Thread.currentThread().getName() + "insuffecient balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "couldnot acquire the lock, will try later");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        if(Thread.currentThread().isInterrupted()){
            System.out.println("interruption in the code, lets not wait");
        }

    }
    public static void main(String[] args) {


    }
}

package Multithreading.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockExample {
    //private final Lock unfairLock = new ReentrantLock();
    private final Lock unfairLock = new ReentrantLock(true);

    public void accessResource(){
        unfairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "acquired the lock");
            Thread.sleep(1000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + "release the lock");
            unfairLock.unlock();
        }
    }
    public static void main(String[] args) {

    }
}

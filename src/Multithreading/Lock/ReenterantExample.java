package Multithreading.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterantExample {
    private final Lock lock = new ReentrantLock();
    public void outerMethod(){
        lock.lock();
        try {
            System.out.println("Outer Method");
            innerMethod();
        } finally {
            lock.unlock();


        }
    }

    public void innerMethod(){
        lock.lock();
        try {
            System.out.println("Inner Method");
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        ReenterantExample example = new ReenterantExample();
        example.outerMethod();
    }
}

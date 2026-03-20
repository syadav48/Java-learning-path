package Multithreading.starttoend.basic;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterAtomicThread {
    private static AtomicInteger count = new AtomicInteger();
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count.incrementAndGet();
            }
        });
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count.incrementAndGet();
            }
        });
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println("Final count:" + count);
    }
}

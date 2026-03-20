package Multithreading.starttoend.basic;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterThread {
    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        });

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println(count);
    }
}

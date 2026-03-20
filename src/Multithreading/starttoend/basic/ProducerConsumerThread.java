package Multithreading.starttoend.basic;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerThread {
    private static final int CAPACITY = 5;
    private static final List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();
        Thread producer = new Thread(() -> {
            int value = 0;
            while (true){
                synchronized (lock){
                    while (list.size() == CAPACITY){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.add(value);
                    System.out.println("Produced: " + value);
                    value++;

                    lock.notify();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
        });
        Thread consumer = new Thread(() -> {
            while (true) {
                synchronized (lock) {

                    while (list.isEmpty()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    int removed = list.remove(0);
                    System.out.println("Consumed: " + removed);

                    lock.notify(); // wake producer
                }

                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {}
            }
        });

        producer.start();
        consumer.start();

    }
}

package Multithreading.ThreadQuestions;

public class Q3_SchedulingDiff {
    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            for (int i = 65; i < 75; i++) {
                System.out.println(Thread.currentThread().getName() + "producing" + Character.toString(i));
                Thread.yield();
            }
        }, "Producer");
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "consuming" + i);
                Thread.yield();
            }
        }, "Consumer");
        producer.start();
        consumer.start();
    }
}

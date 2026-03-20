package Multithreading.starttoend.basic;

public class Q1_CreateThread{
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 6; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " +  i);
            }
        });
        thread1.start();
        thread1.join();
        thread2.start();
    }
}

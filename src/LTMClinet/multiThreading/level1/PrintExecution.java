package LTMClinet.multiThreading.level1;

public class PrintExecution {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        thread1.setName("Thread1");
        thread1.setPriority(10);

        Thread thread2 = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        thread2.setName("Thread2");
        thread1.setPriority(1);

        thread1.start();
        thread2.start();
    }
}

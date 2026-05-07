package Multithreading.LTM.basics;

public class Priority {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                System.out.println(i);
            }
        }, "t1");
        Thread thread2 = new Thread(() -> {
            for (char c = 'a'; c <'a' + 5; c++) {
                System.out.println(c);
            }
        }, "t2");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
    }
}

package LTMClinet.multiThreading.level1;

public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Character.valueOf((char) ('a' + i)));
            }
        });

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(i);
            }
        });

        thread1.start();
        thread2.start();
    }
}

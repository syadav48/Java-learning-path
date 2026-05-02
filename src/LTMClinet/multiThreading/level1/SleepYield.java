package LTMClinet.multiThreading.level1;

public class SleepYield {
   public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                if(i == 2){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName() + " :" + i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 5; i < 10; i++) {
                if(i == 7){
                    Thread.yield();
                }
                System.out.println(Thread.currentThread().getName() + " :" + i);

            }
        });
        thread1.start();
        thread2.start();
        thread2.join();
    }
}

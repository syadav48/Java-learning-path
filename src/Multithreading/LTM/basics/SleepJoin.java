package Multithreading.LTM.basics;

public class SleepJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                if (i == 2) {
                    try {
                        System.out.println(Thread.currentThread().getName()+ "sleeping...");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName() + "   "+ i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                if (i == 2) {
                    try {
                        System.out.println(Thread.currentThread().getName()+ "sleeping...");
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName() + "   " + i);
            }
        });
        thread1.start();
        thread1.join(); //wait for thread1 to finish
        thread2.start();
        System.out.println(thread1.getState() + "checking state111");
        thread2.join(); //wait for thread2 to finish
        System.out.println(thread1.getState() + "checking state222");
        System.out.println(thread2.getState() + "checking state333");

        System.out.println("Main thread finshed");

    }
}

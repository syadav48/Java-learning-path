package Multithreading.ThreadQuestions;

public class Q1_Thread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread is running:" + Thread.currentThread().getName());
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                if(i == 3){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            System.out.println("Thread is running:" + Thread.currentThread().getName());

        }, "Thread2");
        t1.setName("Thread1");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
        t1.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("State:"  + t1.getState() + Thread.currentThread().getName());
        System.out.println("State:"  + t2.getState() + Thread.currentThread().getName());
    }
}

package LTMClinet.multiThreading.level1;

import java.util.concurrent.Callable;

class CreatedThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + ": " + i + 1);
        }
    }
}
class NewTypeThread implements Runnable{

    @Override
    public void run() {
        for (int i = 5; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + ": " + i + 1);
        }
    }
}


public class ThreadCreation {
    public static void main(String[] args) {
        CreatedThread createdThread = new CreatedThread();
        NewTypeThread newTypeThread = new NewTypeThread();
        Thread thread = new Thread(newTypeThread);
        Thread thread1 = new Thread(() -> {
            for (int i = 10; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i + 1);

            }
        });
        createdThread.start();
        thread.start();
        thread1.start();

    }
}

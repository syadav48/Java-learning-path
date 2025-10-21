package Multithreading;

public class LifeCycle extends Thread{

    @Override
    public void run() {
        System.out.println("Running");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
       LifeCycle t1 = new LifeCycle();
       System.out.println(t1.getState());
       t1.start();
        System.out.println(t1.getState());
        LifeCycle.sleep(100);
        System.out.println(t1.getState());
        t1.join();
        System.out.println(t1.getState());
    }
}

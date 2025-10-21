package Multithreading;

public class AnotherWorld implements  Runnable{
    @Override
    public void run() {
        for (; ;) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

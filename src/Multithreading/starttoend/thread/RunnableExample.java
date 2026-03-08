package Multithreading.starttoend.thread;

public class RunnableExample implements Runnable {

    public static void main(String[] args) {
        System.out.println("Inside:" + Thread.currentThread().getName());
        System.out.println("Creating Runnable...");
        Runnable runnableExample = new RunnableExample();
        Thread thread = new Thread(runnableExample);
        System.out.println("Starting Thread...");
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Inside: " + Thread.currentThread().getName());
    }
}

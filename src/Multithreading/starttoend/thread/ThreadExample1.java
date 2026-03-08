package Multithreading.starttoend.thread;

public class ThreadExample1 extends Thread{
    @Override
    public void run(){
        System.out.println("Inside:" + Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        System.out.println("Inside:" + Thread.currentThread().getName());
        System.out.println("creating Thread...");
        Thread thread = new ThreadExample1();
        System.out.println("Thread Started...."+ thread.getName());
        thread.start();

    }
}

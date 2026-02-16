package Multithreading.answers.basic;

public class Q1_Hello {
    public static void main(String[] args){
        Hello hello = new Hello();
        Thread thread2 = new Thread(hello);

        Print print = new Print();
        Thread thread1 = new Thread(print);
        thread1.setName("Thread1");
        thread1.setPriority(1);
        thread2.setName("Thread2");
        thread2.setPriority(2);
        thread1.start();
        thread2.start();


    }
}

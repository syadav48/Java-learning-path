package Multithreading.starttoend.interviewqn.basics;

public class PrintFifty implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 51; i++) {
            System.out.println("Printing 50:" + i);
        }
    }
}

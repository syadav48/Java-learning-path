
package Multithreading.starttoend.interviewqn.basics;

public class PrintFiftytoHundred implements Runnable{

    @Override
    public void run() {
        for (int i = 50; i < 101; i++) {
            System.out.println("Printing 100:" + i);
        }
    }
}


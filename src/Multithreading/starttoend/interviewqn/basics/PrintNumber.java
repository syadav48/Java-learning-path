package Multithreading.starttoend.interviewqn.basics;

public class PrintNumber {
    public static void main(String[] args) throws InterruptedException {
        PrintFifty printFifty = new PrintFifty();
        PrintFiftytoHundred printFiftytoHundred = new PrintFiftytoHundred();
        Thread thread1 = new Thread(printFifty);
        Thread thread2 = new Thread(printFiftytoHundred);
        thread1.start();
        thread2.sleep(20);
        thread2.start();
    }
}

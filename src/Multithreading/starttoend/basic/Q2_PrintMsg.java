package Multithreading.starttoend.basic;

public class Q2_PrintMsg {
    public static void main(String[] args) throws InterruptedException {
        PrintMsg printMsg = new PrintMsg();
        Thread thread = new Thread(printMsg);

        thread.start();
        thread.sleep(2000);

    }
}

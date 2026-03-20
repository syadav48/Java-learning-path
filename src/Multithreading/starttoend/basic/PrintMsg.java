package Multithreading.starttoend.basic;

public class PrintMsg implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println("Hello From Thread");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

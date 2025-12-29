package Multithreading.BeginerLevelProject;

public class ClockThread extends Thread{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Ticking Clock" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){

            }
        }
    }
}

package Multithreading.BeginerLevelProject;

public class DownloadThread extends Thread {
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Downloading File " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){

            }
        }
    }
}

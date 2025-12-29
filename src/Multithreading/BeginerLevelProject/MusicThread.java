package Multithreading.BeginerLevelProject;

public class MusicThread extends  Thread{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("🎵 Playing music " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){

            }
        }
    }

}

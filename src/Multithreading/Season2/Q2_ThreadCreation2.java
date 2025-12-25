package Multithreading.Season2;

class ThreadRunnable implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

public class Q2_ThreadCreation2 {
    public static void main(String[] args) {

    }
}

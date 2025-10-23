package Multithreading.ThreadQuestions;

public class Q2_Thread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                //check if interrupted
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("Thread interrupted cleaning and exiting");
                    break; //Exit the loop gracefully
                }
                System.out.println("check process" + i);
                if(i == 2){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Sleep interrupted: Thread will exit");
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
            System.out.println("Thread finish execution");
        });
        t1.start();
        try {
            Thread.sleep(1000); //wait for 1 second
            System.out.println("Waiting for 1 second");
            t1.interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

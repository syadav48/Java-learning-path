package Multithreading.ThreadQuestions;

class WriteMessages extends Thread{
    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println(Character.toString(70 + i));
        }
        for (char i = 0; i < 5; i++) {
            char ch = (char) (75 + i);
            System.out.println(Character.valueOf(ch));
        }
    }
}

public class PrintMessage{
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (char i = 'A'; i < 'F'; i++) {
                System.out.println(i);
            }
        });
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(i);
                }
            }
        };
        Thread t2 = new WriteMessages();
        Thread t3 = new Thread(runnable);
        t2.start();
        t1.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            System.out.println("state1" + t1.getState());
            System.out.println("state2" + t2.getState());
            System.out.println("state3" + t3.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

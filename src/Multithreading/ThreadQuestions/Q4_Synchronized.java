package Multithreading.ThreadQuestions;

class Counter{
    private int counter;
    public void increment(){
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}

public class Q4_Synchronized {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 1000000; i++){
                counter.increment();
                System.out.println("Current counter t1:" + counter.getCounter());
            }
        },"Thread1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                counter.increment();
                System.out.println("Current counter in t2:" + counter.getCounter());
            }
        },"Thread1");

        t1.start();
        t2.start();



        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main finished:" + counter.getCounter());

    }
}

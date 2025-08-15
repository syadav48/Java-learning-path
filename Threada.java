class A implements Runnable { // earlier it was extends Threads
    public void run() { // earlier it was show
        // mandatory to have the name run
        for (int i = 0; i < 5; i++) {
            // in very low operation, it does not seems like its running parallel, hence
            // increasing this 5 to 100
            System.out.println("Hi");
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
            try { // just tryinh to make both the thread simultanenously
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Threada {
    public static void main(String[] args) {
        Runnable obj1 = () -> {
            // making it Lamda as it is a FUnctional Interface
            for (int i = 0; i < 5; i++) {
                System.out.println("Hi");
                try { // just tryinh to make both the thread simultanenously
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        B obj2 = new B();
        // obj1.show();
        // obj2.show();
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        // obj1.start();
        t1.start();
        t2.start();
        // try {
        // Thread.sleep(5);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // obj2.start();
        // we are suggesting to schedular that, obj1 has max and obj2 has min priority
        // obj1.setPriority(Thread.MAX_PRIORITY);
        // obj2.setPriority(Thread.MIN_PRIORITY);
        // still the logs are not simultaneous, why? we sre just suggesting, schdular
        // will prior based on time consulption in running,
        // it has its own algorithm to prior the task
    }
}

// what is schedular? and what it does in the multi threading operations?

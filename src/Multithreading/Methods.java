package Multithreading;

public class Methods extends Thread{
    public Methods(String name) {
        super(name);
    }

    @Override
    public void run() {
        //setPriority()
//        for (int i = 0; i < 5; i++) {
//            String a = "";
//            for (int j = 0; j < 10000; j++) {
//                a += "a";
//            }
//            System.out.println(Thread.currentThread().getName() + "- Priority: " + Thread.currentThread().getPriority());
//            try {
//                Thread.sleep(100);
//            } catch (Exception e){
//                System.out.println(e);
//            }
//        }
    // interrupt
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Thread is running.....");

//        for (int i = 0; i < 5; i++) {
//            System.out.println(Thread.currentThread().getName() + "is running");
//            Thread.yield();
//        }
        while (true){
            System.out.println("Hello World!");
        }
    }

    public static void main(String[] args) {
//        Methods l = new Methods("Low priority thread");
//        Methods m = new Methods("Medium priority thread");
//        Methods n = new Methods("High priority thread");
//
//        l.setPriority(Thread.MIN_PRIORITY);
//        m.setPriority(Thread.NORM_PRIORITY);
//        l.setPriority(Thread.MAX_PRIORITY);
//
//        l.start();
//        m.start();
//        n.start();

//        Methods t1 = new Methods("Interrupt");
//        t1.start();
//        t1.interrupt();

//        Methods t1 = new Methods("Thread- 1");
//        Methods t2 = new Methods("Thread- 2");
//
//        t1.start();
//        t2.start();

        // setDaemon:
        Methods t1 = new Methods("Daemon");
        t1.setDaemon(true);
        Methods t2 = new Methods("NewDaemon");
        t1.start();
        t2.start();
        System.out.println("Main Done");
    }

}

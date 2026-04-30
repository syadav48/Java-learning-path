package Multithreading.starttoend.basic.basicImp;

public class CreatingThread {
    public static void main(String[] args) throws InterruptedException {
        Print1 print1 = new Print1();
        Print2 print2 = new Print2();
        Thread thread1 = new Thread(print1);
        Thread thread2 = new Thread(print2);
//        thread1.start();
//        thread1.join();
//        thread2.start();
//        thread2.join();
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "  " + i);
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread3.start();




    }
}

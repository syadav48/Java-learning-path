package Multithreading.starttoend.basic.basicImp;

public class PingPong {
    private static final Object lock = new Object();
    private static  boolean isPingTurn = true;
   public static void main(String[] args) {
       Thread thread1 = new Thread(() -> {
           while (true){
               synchronized (lock){
                   while (!isPingTurn){
                       try {
                           lock.wait();
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                   }
                   System.out.println("Ping");
                   isPingTurn = false;

                   lock.notify();
               }
           }
       });
       Thread thread2 = new Thread(() -> {
          while (true){
              synchronized (lock){
                  while(isPingTurn){
                      try {
                          lock.wait();
                      } catch (InterruptedException e) {
                          throw new RuntimeException(e);
                      }
                  }
                  System.out.println("Pong");
                  isPingTurn = true;

                  lock.notify();
              }
          }
       });
       thread1.start();
       thread2.start();
   }
}

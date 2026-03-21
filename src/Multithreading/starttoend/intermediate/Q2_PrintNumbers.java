package Multithreading.starttoend.intermediate;

 class PrintDivByThree implements Runnable{
    int i = 0;
    @Override
    public void run() {
        while (true){
            if(i % 3 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            i++;
        }
    }
}
class PrintDivByFive implements Runnable{
    int i = 0;
    @Override
    public void run() {
        while (true){
            if(i % 5 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            i++;
        }
    }
}
class PrintDivByAll implements Runnable{
    int i = 0;
    @Override
    public void run() {
        while (true){
            if(i % 3 != 0 && i % 5 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            i++;
        }
    }
}


public class Q2_PrintNumbers {
    public static void main(String[] args) {

        Runnable printThree = new PrintDivByThree();
        Runnable printFive = new PrintDivByFive();
        Runnable printAll = new PrintDivByAll();
        Thread thread1 = new Thread(printThree);
        Thread thread2 = new Thread(printFive);
        Thread thread3 = new Thread(printAll);
        thread3.start();
        thread1.start();
        thread2.start();
    }
}

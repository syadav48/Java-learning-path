package Multithreading.Season2;

class MyThread extends Thread{
    public int sum;
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }
}
public class Q1_ThreadCreation {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.start();
        System.out.println(t1.getName());
        System.out.println(t1.getPriority());
        t1.setPriority(5);
        System.out.println(t1.getPriority());
    }
}

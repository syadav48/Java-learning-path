package Multithreading.starttoend.basic.basicImp;

public class Print1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 106; i++) {
            System.out.println(i);
        }
    }
}

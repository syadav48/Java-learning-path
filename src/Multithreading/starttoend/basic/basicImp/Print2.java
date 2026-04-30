package Multithreading.starttoend.basic.basicImp;

public class Print2 extends Thread{
    public void run(){
        for (int i = 106; i < 216; i++) {
            System.out.println(i);
        }
    }
}

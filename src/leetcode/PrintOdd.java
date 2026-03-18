package leetcode;

public class PrintOdd implements Runnable{
    @Override
    public void run() {

            for (int i = 0; i < 100; i++) {
                if(i % 2 != 0){
                    System.out.println("Odd:" + i);
                }
            }


    }
}

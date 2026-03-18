package leetcode;

public class CognizantInterview {

    public static void main(String[] args) {
        PrintEven printEven = new PrintEven();
        PrintOdd printOdd = new PrintOdd();
        Thread thread1    = new Thread(printEven);
        Thread thread2 = new Thread(printOdd);
        thread1.start();
        thread2.start();

    }
}

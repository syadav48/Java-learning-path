package helloInterview.dsa.dp;

public class FibonaciNum {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] fib = new int[n + 1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i-2] + fib[i - 1];
        }
        return fib[n];
    }
    public int fibOpt(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int a = 0;
        int b = 1;
        for(int i = 2; i <= n; i++){
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
    public static void main(String[] args) {
        FibonaciNum fibonaciNum = new FibonaciNum();
        System.out.println(fibonaciNum.fib(4));
    }
}

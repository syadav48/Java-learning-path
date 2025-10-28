package leetcode.math;

public class UglyNumber {

    public static boolean isUgly(int n) {
        if(n <= 0) return false;
        for(int factor: new int[]{2,3,5}){
            while (n % factor == 0){
                n/= factor;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {

        System.out.println(isUgly(-2147483648));
        System.out.println(isUgly(-11));
        System.out.println(isUgly(14));
    }
}

package leetcode.math;

public class palindrome {
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        String numstr = String.valueOf(x);
        String newStr = new StringBuilder(numstr).reverse().toString();
        return numstr.equals(newStr);

    };
    public static void main(String[] args) {
        System.out.println(isPalindrome(123696321));
    }
}
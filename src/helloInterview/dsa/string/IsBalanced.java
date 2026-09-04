package helloInterview.dsa.string;

import java.util.Arrays;

public class IsBalanced {
    public boolean isBalanced(String num) {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            if(i % 2 == 0){
                builder1.append(num.charAt(i));
            } else {
                builder2.append(num.charAt(i));
            }
        }
        int sum1 = Arrays.stream(builder1.toString().split("")).mapToInt(Integer::parseInt).sum();
        int sum2 = Arrays.stream(builder2.toString().split("")).mapToInt(Integer::parseInt).sum();
        return sum1 == sum2;
    }
    public boolean isBalancedOpt(String num) {
        int oddSum = 0;
        int evenSum = 0;
        for(int i = 0; i < num.length(); i++){
            if(i % 2 == 0){
                int digit = num.charAt(i) - '0';
                evenSum += digit;
            } else {
                int digit = num.charAt(i) - '0';
                oddSum += digit;
            }
        }
        return oddSum == evenSum;
    }
    public static void main(String[] args) {
        IsBalanced isBalanced = new IsBalanced();
        System.out.println(isBalanced.isBalanced("24123"));
        System.out.println(isBalanced.isBalancedOpt("24123"));
        System.out.println(isBalanced.isBalanced("1234"));
        System.out.println(isBalanced.isBalancedOpt("1234"));
    }
}

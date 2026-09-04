package helloInterview.dsa.recursion;

public class SumOfDigits {
    public static int sumOfDigit(int num){
        if(num < 10){
            return  num;
        }
        return  num%10 + sumOfDigit(num / 10);
    };
    public static void main(String[] args) {
        System.out.println(sumOfDigit(5466));
    }
}

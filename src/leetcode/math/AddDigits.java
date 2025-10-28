package leetcode.math;

public class AddDigits {
    public static int addDigits(int num) {
        String str = String.valueOf(num);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return String.valueOf(sum).length() == 1 ? sum : addDigits(sum);
    }
    public static void main(String[] args) {
        int num = 38;
        int num1 = 93893;
        int num2 = 0;
        System.out.println(addDigits(num1));
        System.out.println(addDigits(num));
        System.out.println(addDigits(num2));
    }
}

package LTMClinet.core.easy;

public class CheckingPalindrome {
    //Check if a number is palindrome (without converting to string)
    public static boolean checkPalindrome(int num){
        int length = String.valueOf(num).length();
        int left = 0;
        int right = length - 1;
        String numstr = String.valueOf(num);
        while (left <= right){

            if(numstr.charAt(left) != numstr.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static boolean checkWithoutStrPalindrome(int num){
        int reverse = 0;
        int temp = Math.abs(num);
        while (temp != 0){
            reverse = (reverse * 10) + temp % 10;
            temp = temp/10;
        }
        System.out.println(reverse);
        return reverse == num;
    }
    public static String removeAllOccurence(String str, char c){
        StringBuilder builder = new StringBuilder();
        for(char ch: str.toCharArray()){
            if(ch != c){
                builder.append(ch);
            }
        }
        return builder.toString();
    }
    public static void swapTwoNumber(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a + "b: " + b);
    }
    public static void swapWithoutThirdVar(int a, int b){
         a = a + b;
         b = a - b;
         a = a - b;
        System.out.println(a + "b: " + b);
    }
    public static void main(String[] args) {
        int num = 11211;
        String str = "dugjjdjdnjfjdjeeedjdjd";
        System.out.println(CheckingPalindrome.checkPalindrome(num));
        System.out.println(CheckingPalindrome.removeAllOccurence(str, 'd'));
        CheckingPalindrome.swapTwoNumber(4, 9);
        CheckingPalindrome.swapWithoutThirdVar(4, 9);
        System.out.println( CheckingPalindrome.checkWithoutStrPalindrome(num));
    }
}

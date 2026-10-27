package helloInterview.dsa.problems.arrString;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String s1 = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int left = 0;
        int right = s1.length() - 1;
        System.out.println(s1);
        while (right > left){
            if(s1.charAt(left) != s1.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean isPalindromeOpt(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase((s.charAt(right)))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }
}

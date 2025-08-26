 class Solution {
    public boolean isPalindrome(String s1){
        int left = 0;
        int right = s1.length() - 1;
        while (left < right) {
           if(s1.charAt(left) != s1.charAt(right)){
                return false;
           }
           left++;
           right--;
        }
        return true;
    }
    public String firstLetter(String s){
      
        return "S";
    }
    
}

public class Palindrome {
    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.isPalindrome("malalam"));
        System.out.println(obj.isPalindrome("poetry"));
        System.out.println(obj.firstLetter("poetry always fulfills me"));
    }
}

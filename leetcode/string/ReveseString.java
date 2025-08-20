

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(s);
    }
}

public class ReveseString {
    public static void main(String[] args) {
        Solution obj = new Solution();
        char [] s = {'h', 'e', 'l', 'l', 'o'};
        char [] u = {'H', 'a', 'n', 'n', 'a', 'h'};
        obj.reverseString(u);
        obj.reverseString(s);
    }
}

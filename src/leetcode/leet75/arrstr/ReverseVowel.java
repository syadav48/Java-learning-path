package leetcode.leet75.arrstr;

import java.util.Arrays;

public class ReverseVowel {
    public boolean isVowel(char ch){
        String vowels = "AEIOUaeiou";
        return vowels.indexOf(ch) != -1;
    }
    public String reverseVowels(String s) {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(isVowel(ch)){
                builder1.append(ch);
            } else {
                builder2.append(ch);
            }
        }
        builder1.reverse();
        for (int i = 0; i < s.length(); i++) {
            if(isVowel(s.charAt(i))){
                System.out.println(i + "vowel");
                res.append(builder1.charAt(i));
            } else {
                System.out.println(i + "cons");
                res.append(builder2.charAt(i));
            }
        }
        return res.toString();
    }
    public String reverseVowel(String s) {
        int left = 0; int right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (left < right){
            if(!isVowel(arr[left])){
                left++;
            } else if (!isVowel(arr[right])) {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        ReverseVowel reverseVowel = new ReverseVowel();
        String str = "IceCreAmm"; // I e e A -> A e e I -> AceCreIm // cCrm
        System.out.println(reverseVowel.reverseVowel(str));
    }
}

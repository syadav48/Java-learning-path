package leetcode.string;

public class ReverseVowel {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
           if(vowels.contains(String.valueOf(s.charAt(i)))){
               str.append(s.charAt(i));
           }
        }
        str.reverse();
        StringBuilder res = new StringBuilder();
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            if(vowels.contains(String.valueOf(s.charAt(i)))){
                res.append(str.charAt(j));
                j++;
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ReverseVowel reverseVowel = new ReverseVowel();
        String str = "IceCreAm";
        String str1 = "leetcode";
        System.out.println(reverseVowel.reverseVowels(str));
        System.out.println(reverseVowel.reverseVowels(str1));
    }
}

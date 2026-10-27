package helloInterview.dsa.problems.arrString;

import java.util.Objects;

public class ReverseWords {

//    "\\s+"      // one or more whitespaces
//            "\\d+"      // one or more digits
//            "\\D+"      // one or more non-digits
//            "[a-z]+"    // lowercase letters
//            "[A-Za-z]+" // all English letters
//            "[^a-zA-Z]" // anything except letters

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        String[] reversed = reverse(s1);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s2: reversed){
            if(s2.trim().isEmpty()){
                continue;
            }
            stringBuilder.append(s2).append(" ");
        }
        return stringBuilder.toString().trim();
    }
    public String reverseWordsOpt(String s){
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if(i > 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    private String[] reverse(String[] strings){
        int left = 0;
        int right = strings.length - 1;
        while (left < right){
            String temp = strings[left];
            strings[left] = strings[right];
            strings[right] = temp;
            left++;
            right--;
        }
        return strings;
    }
    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        String str = "the sky is blue";
        String str1 = " hello world ";
        String str2 = "a good   example";
        // blue is sky the
        System.out.println(reverseWords.reverseWords(str));
        System.out.println(reverseWords.reverseWords(str1));
        System.out.println(reverseWords.reverseWords(str2));
    }
}

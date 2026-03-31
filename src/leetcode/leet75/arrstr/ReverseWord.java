package leetcode.leet75.arrstr;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWord {
    public String reverseWords(String s) {
       return Arrays.stream(s.trim().split("\\s+")).toList().reversed().stream().collect(Collectors.joining(" "));
    }
    public String reverseWord(String s) {
        List<String> words = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }
   public static void main(String[] args) {
        String s = "the sky is blue"; //"blue is sky the"
        ReverseWord reverseWord = new ReverseWord();
       System.out.println(reverseWord.reverseWords(s));
    }
}

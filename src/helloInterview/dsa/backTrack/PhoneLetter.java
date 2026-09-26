package helloInterview.dsa.backTrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneLetter {
    private Map<Character, String> phone = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );
    private List<String> result;
    private String digits;
    public List<String> letterCombinations(String digits){
        this.digits = digits;
        this.result = new ArrayList<>();

        if (digits.length() > 0) {
            backTrack("", 0);
        }
        return result;
    }
    private void backTrack(String path, int idx){
        if(idx == digits.length()){
            result.add(path);
            return;
        }
        for(char letter: phone.get(digits.charAt(idx)).toCharArray()){
            backTrack(path + letter, idx + 1);
        }
    }

    public static void main(String[] args) {
        PhoneLetter phoneLetter = new PhoneLetter();
        System.out.println(phoneLetter.letterCombinations("24"));
    }
}

package leetcode.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonChar {
        private List<String> commonChars(String[] words) {
            List<String> list = new ArrayList<>();
            List<String> stringList = Arrays.stream(words).toList();
            for(int i = 0; i < stringList.size(); i++){

            }
            return  list;
        }

    public static void main(String[] args) {
       String[] words = {"bella","label","roller"};
        CommonChar obj = new CommonChar();
        obj.commonChars(words);

    }
}

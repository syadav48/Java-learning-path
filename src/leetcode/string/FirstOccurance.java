package leetcode.string;

import java.util.Arrays;

public class FirstOccurance {
    public int strStr(String haystack, String needle) {
        int index = 0;
        while (index + needle.length() <= haystack.length()){

            if(haystack.substring(index, index + needle.length()).equals(needle)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstOccurance obj = new FirstOccurance();
        int index = obj.strStr("leetcode", "leeto");
        System.out.println(index);
    }
}

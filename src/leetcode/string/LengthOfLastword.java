package leetcode.string;

import java.util.Arrays;

public class LengthOfLastword {
    public int lengthOfLastWord(String s) {
        String[] strarr = s.trim().split(" ");
        String str = strarr[strarr.length - 1];
        int strLength = str.length();
        return strLength;
    }
    public static void main(String[] args) {
        LengthOfLastword obj = new LengthOfLastword();
        obj.lengthOfLastWord("  fly me   to   the moon  ");
        obj.lengthOfLastWord("luffy is still joyboy");
    }
}

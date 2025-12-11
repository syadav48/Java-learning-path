package leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NoOfLines {
    public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];
        Map<Character, Integer> map = new HashMap<>();
        String str = "abcdefghijklmnopqrstuvwxyz";
        int sum = 0;
        for (int i = 0; i < widths.length; i++) {
            map.put(str.charAt(i), widths[i]);
        }
        for (int i = 0; i < s.length(); i++) {
           sum += map.get(s.charAt(i));
            System.out.println(sum);
        }
        System.out.println(sum);
        result[0] = sum / 100 + 1;
        result[1] = sum % 100;
        System.out.println(map);
        return result;
    }
    public static void main(String[] args) {
        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "bbbcccdddaaa";
        NoOfLines noOfLines = new NoOfLines();
        System.out.println(Arrays.toString(noOfLines.numberOfLines(widths, s)));
    }
}

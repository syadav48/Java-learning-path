package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class ColumnNumber {
    public static int titleToNumber(String columnTitle) {
        Map<Character, Integer> map = new HashMap<>();
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int idx = 1;
        double sum = 0;
        for(char ch: alphabets.toCharArray()){
            map.put(ch, idx);
            idx++;
        }
        for(int i = 0; i < columnTitle.length(); i++){
            double mf = Math.pow((double) idx - 1, columnTitle.length() - (i+1));
            int pos = map.get(columnTitle.charAt(i));
            System.out.println(pos);
            System.out.println(mf);
            sum += mf * pos;
        }
        System.out.println(map);
        return (int) sum;
    }

    public static int titleToNumberII(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char ch = columnTitle.charAt(i);
            int pos = ch - 'A' + 1;
            result = result * 26 + pos;

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumberII("ZY"));

    }
}

package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class ColumnTitle {
    public static String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
        while (columnNumber > 0){
            columnNumber--;
            int remaider = columnNumber % 26;
            str.append((char) ('A' + remaider));
            columnNumber /= 26;
        }
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(7));

    }
}

package leetcode.math;

import java.util.Arrays;
import java.util.SimpleTimeZone;

public class ConvertDateToBinary {
    public String convertDateToBinary(String date) {
        String[] arr = date.split("-");
        StringBuilder builder = new StringBuilder();
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            int value = Integer.parseInt(arr[i]);
            System.out.println(value);
            String binary = Integer.toBinaryString(value);

            builder.append(binary);

            if (i < arr.length - 1) {
                builder.append("-");
            }
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        ConvertDateToBinary convertDateToBinary = new ConvertDateToBinary();
        String string = "2080-02-29";
        System.out.println(convertDateToBinary.convertDateToBinary(string));
    }
}

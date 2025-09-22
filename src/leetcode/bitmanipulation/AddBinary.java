package leetcode.bitmanipulation;

import java.math.BigInteger;

public class AddBinary {
    public static String addBinary(String a, String b) {
        int x = Integer.parseInt(a, 2);
        int y = Integer.parseInt(b, 2);
        return Integer.toBinaryString(x + y);
    }
    public static String addBinaryII(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger sum = x.add(y);
        return sum.toString();
    }
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinaryII(a, b));
    }
}

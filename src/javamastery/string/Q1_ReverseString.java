package javamastery.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Q1_ReverseString {

    public static String reverseString1(String s){
        return new StringBuilder(s).reverse().toString().toLowerCase();
    };
    public static String reverseString2(String s){
        StringBuilder str = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            str.append(s.charAt(i));
        }
        return str.toString().toLowerCase();
    };
    public static String reverseString3(String s){
        return Arrays.stream(s.split(""))
                .reduce("", (rev, ch) -> {
                    System.out.println(rev + " " + ch);
                    return ch + rev;
                })
                .toLowerCase();
    };

    public static void main(String[] args) {
        String s1 = "Rekha";
        String s2 = "Khera";
        String s3 = "Rakhi";
        System.out.println(reverseString1(s1));
        System.out.println(reverseString2(s2));
        System.out.println(reverseString3(s3));
    }
}
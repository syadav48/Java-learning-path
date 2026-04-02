package javamastery.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseEach {

    public static void main(String[] args) {
       String s = "hello world";
       String str = "java is awesome";
        String collect = Arrays.stream(s.split(" ")).toList().stream().map(x -> new StringBuilder(x).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(collect);

        String collect1 = Arrays.stream(str.split(" ")).toList().stream().map(x -> Character.toUpperCase(x.charAt(0)) + x.substring(1))
                .collect(Collectors.joining(" "));
        System.out.println(collect1);


    }
}

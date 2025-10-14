package javamastery.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q1_StreamCreation {
    public static List<Integer> printEven(List<Integer> list){
            return list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
    }
    public static List<String> toUpperCase(List<String> names){
            return names.stream()
                    .map(x -> x.toUpperCase().charAt(0) + x.substring(1)
                             .toLowerCase()).toList();
    }
    public static Long countWords(List<String> words){
        return words.stream().filter(x -> x.toLowerCase().startsWith("a")).count();
    }
    public static Integer productSum(List<Integer> list){
        return  list.stream().reduce(1, (x, y) -> x * y)
        + list.stream().reduce(0, Integer::sum);
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> names = Arrays.asList("ram", "shyam", "mohan");
        List<String> words = Arrays.asList("ram", "shyam", "mohan", "alia", "akram", "zinda", "ziva");
        System.out.println(printEven(list));
        System.out.println(toUpperCase(names));
        System.out.println(countWords(words));
        System.out.println(productSum(list));
    }
}

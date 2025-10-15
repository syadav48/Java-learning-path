package javamastery.stream.Intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SummarizingStastics {
    public static Object summarizingInt(List<Integer> list){
        return list.stream().collect(Collectors.summarizingInt(x -> x));
    }
    public static String splitString(List<String> list){
        String splitted = list.stream().collect(Collectors.joining("-"));
        String str = list.stream().reduce("", (x, y) -> x.concat(y).concat("-"));
        System.out.println(str);
        String strs = list.stream().collect(Collectors.reducing("", (x, y) -> x.concat(y)));
        System.out.println(strs);
        return splitted;
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> cities = Arrays.asList("Delhi", "Mumbai", "Pune");
        System.out.println(summarizingInt(list));
        System.out.println(splitString(cities));
    }
}

package javamastery.stream.Intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q5_GroupByCount {
    public static Map<Character, Long> countByFirstLetter(List<String> names){
        return names.stream().collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()));
    }
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram", "Ravi", "Ramesh", "Sita", "Sunil", "Jyoti", "Priti");
        System.out.println(countByFirstLetter(names));
    }
}

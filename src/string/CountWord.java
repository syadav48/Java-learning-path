package string;

import java.util.Arrays;
import java.util.List;

public class CountWord {
    public static void main(String[] args) {
        String str = "Java is awesome";
        List<String> list = Arrays.asList(str.split(" "));
        list.stream()
                .map(e -> Character.toUpperCase(e.charAt(0)) + e.substring(1).toLowerCase())
                .forEach(System.out::println);
    }
}

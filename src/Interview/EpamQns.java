package Interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EpamQns {
    public static void main(String[] args) {
        String str = "hello world";
        Arrays.stream(str.substring(5).split("")).toList();

        String collect = Arrays.stream(str.split(" "))
                .toList().stream().map(x -> Character.toUpperCase(x.charAt(0)) + x.substring(1))
                .collect(Collectors.joining(" "));
        System.out.println(collect);
    }
}

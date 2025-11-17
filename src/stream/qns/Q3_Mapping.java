package stream.qns;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q3_Mapping {
    public static void main(String[] args) {
        // 1
        List<String> list = DataFactory.employees().stream().map(x -> x.getName().toUpperCase()).toList();
        System.out.println(list);

        //2
        List<String> words =
                DataFactory.sentences().stream().map(x -> x.split(" "))
                        .flatMap(x -> Arrays.stream(x)).toList();

        System.out.println(words);

        // 3
        List<String> skills = DataFactory.employees().stream().map(x -> x.getSkills())
                .flatMap(arr -> arr.stream())
                .distinct()
                .toList();
        System.out.println(skills);


    }
}

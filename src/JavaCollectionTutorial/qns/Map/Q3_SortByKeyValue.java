package JavaCollectionTutorial.qns.Map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Q3_SortByKeyValue {
    public static void main(String[] args) {
        //1
        HashMap<String, Integer> map = new HashMap<>(Map.of(
                "T", 23,
                "N", 34,
                "B", 11,
                "E", 55
        ));
        System.out.println(map);
        Stream<Map.Entry<String, Integer>> sortedByKey = map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey));
        sortedByKey.forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
        //2
        Stream<Map.Entry<String, Integer>> sortedByValue = map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));
        sortedByValue.forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));

        //3
        List<String> list = map.keySet().stream().sorted(Comparator.reverseOrder()).toList();
        List<Integer> list1 = map.values().stream().sorted().toList();

        System.out.println(list);
        System.out.println(list1);
        System.out.println(map.entrySet());


    }

}

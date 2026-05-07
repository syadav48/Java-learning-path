package LTMClinet.core.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortByValue {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        LinkedHashMap<String, Integer> collect = map.entrySet().stream().sorted
                (Comparator.comparing(x -> x.getValue(), Comparator.reverseOrder())).limit(2).collect(
                Collectors.toMap(
                        x -> x.getKey(),
                        x -> x.getValue(),
                        (e1, e2) -> e1,
                        LinkedHashMap::new

                )
        );
        System.out.println(collect);

        System.out.println();
    }
}

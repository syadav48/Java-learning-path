package JavaCollectionTutorial.qns.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Q6_MergeMap {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 10);
        map1.put("banana", 20);
        map1.put("cherry", 30);


        Map<String, Integer> map2 = new HashMap<>();
        map2.put("banana", 40);   // duplicate key with different value
        map2.put("date", 50);
        map2.put("elderberry", 60);


        Map<String, Integer> merged =
                new HashMap<>(map1);

        map2.forEach((key, value) ->
                merged.merge(key, value, Integer::sum)
        );

        Map<String, Integer> collect = merged.entrySet().stream().filter(x -> x.getValue() > 10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(merged);
        System.out.println(collect);





    }
}

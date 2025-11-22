package JavaCollectionTutorial.qns.Map;

import java.util.*;

public class Q8_ListToSIngleList {
    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("A", List.of(1, 2, 3));
        map.put("B", List.of(4, 5));
        map.put("C", List.of(6, 7, 8, 9));
        List<Integer> list = new ArrayList<>();

        List<Integer> list1 = map.values().stream().flatMap(Collection::stream).toList();
        System.out.println(list1);
    }
}

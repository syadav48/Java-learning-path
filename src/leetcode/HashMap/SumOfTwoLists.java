package leetcode.HashMap;

import java.util.*;

public class SumOfTwoLists {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, List<Integer>> map3 = new HashMap<>();
        List<String> stringList = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        for(String key: map1.keySet()){
            List<Integer> list = new ArrayList<>();
            list.add(map1.get(key));
            list.add(map2.get(key));
            map3.put(key, list);
        };
        System.out.println(map3);
        for(List<Integer> list: map3.values()){
            if(!list.contains(null)){
                min = Math.min(min, list.stream().reduce(0, Integer::sum));
            }
        }
        System.out.println(min);
        for(Map.Entry<String, List<Integer>> entry: map3.entrySet()){
            if(!entry.getValue().contains(null) && entry.getValue().stream().reduce(0, Integer::sum).equals(min)){
                stringList.add(entry.getKey());
            }
        }
        String[] arr = stringList.toArray(new String[0]);
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static String[] findRestaurant2(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        // store first list items with index
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        // check for common strings in list2
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                int sum = j + map.get(list2[j]);
                if (sum < minSum) {
                    result.clear(); // new minimum found
                    result.add(list2[j]);
                    minSum = sum;
                } else if (sum == minSum) {
                    result.add(list2[j]); // tie case
                }
            }
        }
        System.out.println(Arrays.toString(result.toArray(new String[0])));
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] list1 = {"happy","sad","good"};
        String[] list2 = {"sad","happy","good"};
        System.out.println(findRestaurant2(list1, list2));
    }
}

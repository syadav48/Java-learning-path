package helloInterview.dsa.problems.searchSorting;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        TreeMap<Integer, String> timeMap = map.get(key);
        System.out.println(timeMap);
        Integer time = timeMap.floorKey(timestamp);
        System.out.println(time);
        if(time == null){
            return "";
        }
       return map.get(key).get(time);
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        timeMap.set("foo", "bar2", 4);

        System.out.println(
                "\n" +
                        timeMap.get("foo", 1) + "\n" +
        timeMap.get("foo", 3) +  "\n" +
        timeMap.get("foo", 4) +  "\n " +
        timeMap.get("foo", 5)
        );


    }
}

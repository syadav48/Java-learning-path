package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LearnMap {
    public static void main(String[] args) {
        Map<String, Integer> numbers = new TreeMap<>();
        HashMap<String, String> capitalCities = new HashMap<String, String>();

        // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("India", "New Dehli");
        capitalCities.put("Austria", "Wien");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("Norway", "Oslo"); // Duplicate
        capitalCities.put("USA", "Washington DC");

        System.out.println(capitalCities);
        numbers.put("One", 1);
        numbers.put("Two", 2);
        numbers.put("Three", 3);
        numbers.put("Four", 4);
        numbers.put("Five", 5);


        numbers.remove("Three");

//        if(!numbers.containsKey("Two")) {
//            numbers.put("Two", 23);
//        }

//        numbers.putIfAbsent("Two", 23);
        System.out.println(numbers);
        System.out.println(numbers.containsValue(3));

        System.out.println(numbers.isEmpty());

//        for (Map.Entry<String, Integer> e: numbers.entrySet()) {
//            System.out.println(e);
//
//            System.out.println(e.getKey());
//            System.out.println(e.getValue());
//        }
//
//        for (String key: numbers.keySet()) {
//            System.out.println(key);
//        }
//
//        for(Integer value: numbers.values()) {
//            System.out.println(value);
//        }

    }
}

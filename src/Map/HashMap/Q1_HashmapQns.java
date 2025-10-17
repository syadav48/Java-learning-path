package Map.HashMap;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q1_HashmapQns {
    public static void countChar(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        //System.out.println(map);
         Map<String, Long> strmap = Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(x -> x,
                Collectors.counting()));
        //System.out.println(strmap);
         Map<Character, Long> charmap = str.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(charmap);
    }
    public static void countNames(List<String> list){
        Map<String, Integer> integerMap = new HashMap<>();
        for(String str: list){
            integerMap.put(str, integerMap.getOrDefault(str, 0) + 1);
        }
        //System.out.println(integerMap.entrySet());
        integerMap.entrySet().removeIf(x -> x.getValue() == 1);
        System.out.println(integerMap);

          Map<String, Long> map = list.stream().collect(Collectors.groupingBy(x -> x,
                Collectors.counting())).entrySet().stream().filter(x -> x.getValue() > 1)
                          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(map);

    }
    public static void mergeTwoMap(Map<String, Integer> map1, Map<String, Integer> map2){
                 map2.forEach((key, val) -> map1.merge(key, val, (a, b) -> a > b ? a : b));
        System.out.println(map2);
    }
    public static void main(String[] args) {
        String str = "programming";
        List<String> list = Arrays.asList("John", "Mary", "John", "Alex", "Mary", "Steve");
        Map<String, Integer> map1 = Map.of(
                "Apple", 80,
                "Banna", 60
        );
        Map<String, Integer> map2 = Map.ofEntries(
                Map.entry("Banana", 70),
                Map.entry("Ornages", 90)
        );
        countNames(list);
        countChar(str);
        //mergeTwoMap(map1, map2);
    }
}

package LTMClinet.core.medium;

import java.util.*;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {
    public static char firstChar(String str){
        Map<String, Long> collect = Arrays.stream(str.split("")).collect(
                Collectors.groupingBy(
                        x -> x,
                        HashMap::new,
                        Collectors.counting()
                )
        );
        for (Map.Entry<String, Long> map: collect.entrySet()){
            if(map.getValue() == 1){
                return map.getKey().charAt(0);
            }
        }
        return '\0';
    }

    public static String swapChar(String str){
        String[] strings = str.split(" ");
        StringBuilder res = new StringBuilder();
        for(String st: strings){
          StringBuilder builder = new StringBuilder(st);
          char temp1 = builder.charAt(0);
          char temp2 = builder.charAt(1);
           builder.setCharAt(0, temp2);
           builder.setCharAt(1, temp1);
            res.append(builder);
            res.append(" ");
        }
        return res.toString();
    }
    public static void swapMapVal(HashMap<String, Integer> map){
        Map<String, Integer> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        x -> x.getKey(),
                        x -> x.getValue(),
                        (old, newVal) -> newVal,
                        LinkedHashMap::new
                ));
        System.out.println(collect);
    }
    public static void findIntersection(int[] arr1, int[] arr2){
        List<Integer> list = new ArrayList<>();
        int length = Math.min(arr1.length, arr2.length);


    }

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int[] arr1 = {1,2,2,1};
        int[] arr2 = {2,2};
        hashMap.put("S", 5);
        hashMap.put("T", 9);
        hashMap.put("B", 13);
        hashMap.put("C", 93);
        hashMap.put("Z", 32);
        System.out.println(FirstNonRepeatingChar.firstChar("swiss"));
        System.out.println(FirstNonRepeatingChar.swapChar("Hello World")); // eHllo oWrld
        FirstNonRepeatingChar.swapMapVal(hashMap);
        FirstNonRepeatingChar.findIntersection(arr1, arr2);

    }
}

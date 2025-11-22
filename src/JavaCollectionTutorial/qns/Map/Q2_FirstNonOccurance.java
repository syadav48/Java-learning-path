package JavaCollectionTutorial.qns.Map;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Q2_FirstNonOccurance {
    public static void main(String[] args) {
        String str = "ACHURUUURCTEEWA";
        LinkedHashMap<String, Long> collect1 = Arrays.stream(str.split("")).collect(Collectors.groupingBy(
                x -> x,
                LinkedHashMap::new,
                Collectors.counting()
        ));
        Map.Entry<String, Long> firstNonOccurance = collect1.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().orElseThrow();
        for(String ch: collect1.keySet()){
            if(collect1.get(ch) == 1){
                System.out.println(ch);
            }
        }
        System.out.println(collect1);
        System.out.println(firstNonOccurance);
    }
}

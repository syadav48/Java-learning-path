package stream.InterviewPractice;

import java.util.*;
import java.util.stream.Collectors;

public class Q1_DuplicatesList {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,1,1,3,5,6,7);
        List<Integer> list1 = list.stream().distinct().toList();
       List<Integer> list2 = new ArrayList<>();
        Map<Integer, Long> collect = list.stream().collect(
                Collectors.groupingBy(
                        x -> x, Collectors.counting()
                )
        );
        for(Map.Entry<Integer, Long> entry: collect.entrySet()){
            if(entry.getValue() > 1){
                list2.add(entry.getKey());
            }
        }

        Set<Integer> seen = new HashSet<>();

        List<Integer> list3 = list.stream().filter(
                x -> !seen.add(x)
        ).distinct().toList();
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
    }
}

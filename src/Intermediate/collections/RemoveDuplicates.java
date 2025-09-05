package Intermediate.collections;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 4, 5, 3, 7, 4, 8, 9, 11, 12, 3);
        List<Integer> newList = new ArrayList<>();
        Set<Integer> set = new LinkedHashSet<>(list);
        System.out.println(set);
        List<Integer> list1 = list.stream().distinct().toList();
        System.out.println(list1);
        for(Integer num: list){
            if(!newList.contains(num)){
                newList.add(num);
            }
        }
        System.out.println(newList);

    }
}

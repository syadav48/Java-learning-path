package Intermediate.collections;

import java.util.*;

public class Intersection {

    private static int intersect(List<Integer> list1, List<Integer> list2){
        Set<Integer> set = new HashSet<>(list2);
        List<Integer> res = new ArrayList<>();
        for(int num1: list1){
           if(set.contains(num1)){
               res.add(num1);
           }
        }
        List<Integer> newList = list1.stream().filter(list2::contains).toList();
        System.out.println(res);
        System.out.println(newList);
        return -1;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3,4,5,6,7,8));
        int num = intersect(list2, list1);
        System.out.println(num);

    }


}

package javamastery.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Repeating {
    public int[] nonRepeatingChar(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int i: arr){
            set.add(i);
        }
        return set.stream().mapToInt(x -> x).toArray();
    }
    public static void main(String[] args) {
        Repeating repeating = new Repeating();
        int[] arr = {1,2,3,4,4,5,5,6,6,6,6};
        System.out.println(Arrays.toString(repeating.nonRepeatingChar(arr)));

    }
}

package leetcode.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class UnplacedFruit {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        List<Integer> list = new ArrayList<>();
        for(int i: baskets){
            list.add(i);
        }
        int unplaced = fruits.length;
        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if(fruits[i] <= list.get(j)){
                    unplaced--;
                    list.remove(list.get(j));
                    break;
                }
            }
        }
        return unplaced;
    }
    public static void main(String[] args) {
        int[] fruits = {3,6,1};
        int[] baskets = {4,6,7};
        UnplacedFruit unplacedFruit = new UnplacedFruit();
        System.out.println(unplacedFruit.numOfUnplacedFruits(fruits, baskets));
    }
}

package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<Integer> generateList(int num){
        List<Integer> list = new ArrayList<>();
        list.add(0, 1);
        list.add(1, 1);
        Integer third = list.stream().reduce(0, Integer::sum);
        list.add(2, third);
        return list;
    }
    public static void generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i <= numRows; i++){
            List<Integer> res = generateList(i);
            result.add(i, res);
        }
        System.out.println(result);

    }
    public static void main(String[] args) {
        generate(1);
    }
}

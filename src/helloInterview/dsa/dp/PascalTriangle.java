package helloInterview.dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    private List<Integer> nextList(List<Integer> integerList){
        int n = integerList.size();
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i < n; i++) {
            int num = integerList.get(i - 1) + integerList.get(i);
            res.add(num);
        }
        res.add(1);
        return res;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows >= 1) list.add(List.of(1));
        if (numRows >= 2) list.add(List.of(1, 1));
        for (int i = 2; i < numRows; i++) {
            List<Integer> getNext = nextList(list.get(i - 1));
            list.add(getNext);
        }
        return list;
    }
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        if (rowIndex >= 1) list.add(List.of(1));
        if (rowIndex >= 2) list.add(List.of(1, 1));
        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> getNext = nextList(list.get(i - 1));
            list.add(getNext);
        }
        return list.get(rowIndex);
    }

    public List<Integer> getRowOpt(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long val = 1; // use long to avoid overflow during calculation
        for (int k = 0; k <= rowIndex; k++) {
            row.add((int) val);
            System.out.println(val +"first");
            val = val * (rowIndex - k) / (k + 1);
            System.out.println(val +"last");
        }
        return row;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        System.out.println(pascalTriangle.getRowOpt(3));
    }
}

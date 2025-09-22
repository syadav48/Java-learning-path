package leetcode.arrays.stack;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
//    public static boolean isInteger(String str) {
//        if (str == null) return false;
//        try {
//            Integer.parseInt(str);
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }

    public static int calPoints(String[] operations) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < operations.length; i++){
             if (operations[i].equals("C")) {
                list.removeLast();
            } else if (operations[i].equals("D")) {
                String dbl = String.valueOf(Integer.parseInt(list.getLast())*2);
                list.add(dbl);
            } else if (operations[i].equals("+")) {
                String add = String.valueOf(Integer.parseInt(list.getLast()) + Integer.parseInt(list.get(list.size() - 2)));
                list.add(add);
            } else {
                 list.add(operations[i]);
             }
        }
        return list.stream().map(Integer::parseInt).reduce(0, Integer::sum);
    };
    public static void main(String[] args) {
        String[] operations = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(operations));
    }
}

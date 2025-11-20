package JavaCollectionTutorial.qns.List;

import stream.qns.DataFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q13_RotatePosition {
    public static void main(String[] args) {

        int k = 3;
        List<Integer> list = Arrays.stream(DataFactory.numberArray()).boxed().toList();
        List<Integer> list1 = list.subList(0, k);
        List<Integer> list2 = list.subList(k, list.size());
        List<Integer> list3 = new ArrayList<>(list2.stream().toList());
        list3.addAll(list1.stream().toList());
        System.out.println(list + " " + list1 + " " + list2 + " " + list3);

        // main-logic: working one:

        List<Integer> list4 = new ArrayList<>(List.of(1,2,3,4,5,6,7));
        int k1 = 3;
        int n = list4.size();
        k1 = k1 % n;
        List<Integer> result = new ArrayList<>();
        result.addAll(list4.subList(n-k1, n));
        result.addAll(list4.subList(0, n-k1));
        System.out.println(result);



    }
}

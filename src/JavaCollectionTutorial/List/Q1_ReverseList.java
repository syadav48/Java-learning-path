package JavaCollectionTutorial.List;

import stream.qns.DataFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Q1_ReverseList {
    public static void main(String[] args) {
        //1
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        List<Integer> list1 = list.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(list1);
        Collections.reverse(list);
        System.out.println(list);

        // without using stream and reverse methods:
        for(int i = 0, j = list.size() - 1; i < j; i++, j--){
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
        System.out.println(list);
    }
}

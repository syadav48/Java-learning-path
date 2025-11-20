package JavaCollectionTutorial.qns;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Q9_SingleList {
    public static void main(String[] args) {
        List<List<Integer>> listOfList = new ArrayList<>(List.of(List.of(1,2,3), List.of(4,5,6), List.of(7,8,9)));
        List<Integer> list = listOfList.stream().flatMap(x -> x.stream()).toList();
        System.out.println(list);
    }
}

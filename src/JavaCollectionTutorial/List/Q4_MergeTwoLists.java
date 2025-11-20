package JavaCollectionTutorial.List;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Q4_MergeTwoLists {
    public static void main(String[] args) {
        List<Integer> listA = new ArrayList<>(Arrays.asList(1, 2, 5, 0, 2, 3, 4, 5));
        List<Integer> listB = new ArrayList<>(List.of(1, -2, 3, -4, 0, 6,7, 8));

        listA.addAll(listB);
        List<Integer> list = listA.stream().distinct().toList();
        System.out.println(list);
        // above one is unmodifiable:

        List<Integer> result = new ArrayList<>(new LinkedHashSet<>(listA));
        System.out.println(result);

        // another one is :
        ArrayList<Integer> collect = listA.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect);

//        If you need control → use toCollection()
//        If you don’t → use toList()

    }
}

package stream.qns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q4_Sorting {
    public static void main(String[] args) {
        //1
        List<String> list = List.of("Dog", "Apple", "Elephant", "Banana", "Cow");
        List<String> sorted = list.stream().sorted().toList();
        System.out.println(sorted);

        //2
        //Arrays.stream(DataFactory.numberArray()).sorted().collect(Comparator.reverseOrder())
        int[] nums = Arrays.stream(DataFactory.numberArray()).boxed().sorted(Comparator.reverseOrder())
                .mapToInt(x -> x.intValue()).toArray();
        List<Integer> list1 = DataFactory.numbers().stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(list1);
        System.out.println(Arrays.toString(nums));

        //3 - incomplete
         List<String> list2 = DataFactory.employees().stream().sorted(
                 Comparator.comparing(Employee ::getSalary).thenComparing(Employee :: getName)
         ).map(x -> x.getName()).toList();
        System.out.println(list2);

        //4
         List<String> transactions = DataFactory.transactions().stream().sorted(Comparator.comparing(x -> x.getDate()))
                 .map(x -> x.getTxnId())
                 .toList();
        System.out.println(transactions);

    }
}

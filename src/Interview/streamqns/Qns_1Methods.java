package Interview.streamqns;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Qns_1Methods {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,2,2,2);
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        HashSet<Integer> set = new HashSet<>();
        List<Integer> withoutDuplicates =  list.stream().filter(set::add).collect(Collectors.toList());
        List<Integer> withDuplicates =  list.stream().filter(x -> !set.add(x)).toList();
        List<Double> result = decimalList.stream().distinct().sorted(Comparator.reverseOrder()).toList();
        System.out.println(withoutDuplicates);
        System.out.println(withDuplicates);
        System.out.println(result);
    }
}

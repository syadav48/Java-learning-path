package LTMClinet.streams;

import stream.qns.DataFactory;

import java.util.Comparator;
import java.util.List;

public class Section5 {
    public static void main(String[] args) {
        List<Integer> list = DataFactory.numbers().stream().distinct().toList();
        List<String> list1 = DataFactory.employees().stream().sorted(Comparator.comparing(x -> x.getSalary())).limit(3)
                .map(x -> x.getName()).toList();
        List<Integer> list2 = DataFactory.numbers().stream().skip(5).toList();
        System.out.println(list);
        System.out.println(list1);
        System.out.println(list2);
    }
}

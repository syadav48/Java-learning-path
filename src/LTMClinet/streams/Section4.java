package LTMClinet.streams;

import stream.qns.DataFactory;
import stream.qns.Employee;

import java.util.Comparator;
import java.util.List;

public class Section4 {
    public static void main(String[] args) {
        List<String> list4 = DataFactory.employees().stream().sorted(
                Comparator.comparing(x -> x.getName(), Comparator.reverseOrder())
        ).map(x ->x.getName()).toList();
        System.out.println(list4);
        List<Integer> list = DataFactory.numbers().stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(list);
        List<String> list1 = DataFactory.employees().stream().sorted(
                Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)
        ).map(x -> x.getName()).toList();
        System.out.println(list1);
        List<Integer> list2 = DataFactory.orders().stream().sorted(
                Comparator.comparing(x -> x.getOrderDate())
        ).map(x -> x.getCustomerId()).toList();
        System.out.println(list2);
    }
}

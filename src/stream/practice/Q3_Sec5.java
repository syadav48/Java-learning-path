package stream.practice;

import stream.qns.DataFactory;
import stream.qns.Employee;
import stream.qns.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Q3_Sec5 {
    public static void main(String[] args) {
        List<Integer> list = DataFactory.numbers().stream().distinct().toList();
        System.out.println(list);

        List<String> list1 = DataFactory.employees().stream().sorted(
                Comparator.comparing(
                        x -> x.getSalary(),
                        Comparator.reverseOrder()
                )
        ).limit(3).map(x -> x.getName()).toList();

        System.out.println(list1);

        List<Integer> list2 = DataFactory.numbers().stream().skip(5).toList();
        System.out.println(list2);

        List<Double> doubleList = Stream.generate(() -> 100*Math.random()).limit(5).toList();
        System.out.println(doubleList);

        boolean match = DataFactory.employees().stream().allMatch(x -> x.getAge() > 18);
        System.out.println(match);

        boolean match1 = DataFactory.transactions().stream().anyMatch(x -> x.getType().equals(Transaction.Type.REFUND));
        System.out.println(match1);

        boolean admin = DataFactory.roleToUsers().keySet().stream().findAny().equals("ADMIN");
        System.out.println(admin);

        Employee employee = DataFactory.employees().stream().filter(x -> x.getSalary() > 100000).findFirst().orElseThrow();
        System.out.println(employee.getName());
    }
}

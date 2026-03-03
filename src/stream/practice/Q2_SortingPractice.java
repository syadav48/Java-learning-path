package stream.practice;

import stream.qns.DataFactory;
import stream.qns.Employee;
import stream.qns.Transaction;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Q2_SortingPractice {
    public static void main(String[] args) {
        List<String> list = DataFactory.products().stream().map(x -> x.getName()).sorted(
                Comparator.naturalOrder()
        ).toList();
        System.out.println(list);

        List<Integer> list1 = DataFactory.numbers().stream().sorted(
                Comparator.naturalOrder()
        ).toList();
        System.out.println(list1);

        List<String> list2 = DataFactory.employees().stream().sorted(
                Comparator.comparing(Employee::getSalary).thenComparing(
                        Comparator.comparing(Employee::getName).reversed()
                )
        ).map(Employee::getName).toList();

        List<String> list3 = DataFactory.employees().stream().sorted(
                Comparator.comparing(Employee::getSalary).thenComparing(
                        Employee::getName).reversed()
        ).map(Employee::getName).toList();

        System.out.println(list3);

        List<LocalDate> list4 = DataFactory.transactions().stream().sorted(
                Comparator.comparing(Transaction::getDate)
        ).map(x -> x.getDate()).toList();

        System.out.println(list4);
    }
}

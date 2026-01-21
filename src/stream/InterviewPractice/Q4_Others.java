package stream.InterviewPractice;

import stream.qns.DataFactory;
import stream.qns.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Q4_Others {
    public static void main(String[] args) {
        List<Integer> list = DataFactory.numbers().stream().distinct().toList();
        List<Double> list1 = DataFactory.employees().stream().sorted(
                Comparator.comparing(x -> x.getSalary(), Comparator.reverseOrder())
        ).limit(3).map(x -> x.getSalary()).toList();


        DataFactory.numbers().stream().skip(2).toList();

        DataFactory.numbers().stream().findAny().orElseThrow();


        System.out.println(list1);
        System.out.println(list);

        String str =  DataFactory.products().stream().map(x -> x.getName()).reduce("", (acc, curr) -> acc.length() > curr.length() ? acc : curr);
        System.out.println(str);

        String string = DataFactory.employees().stream().reduce(
                (e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2
        ).map(Employee::getSalary).toString();

        Optional<Employee> max = DataFactory.employees().stream().max(
                Comparator.comparing(
                        x -> x.getSalary(), Comparator.naturalOrder()
                )
        );

    }
}

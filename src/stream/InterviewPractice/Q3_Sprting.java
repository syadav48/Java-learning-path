package stream.InterviewPractice;

import stream.qns.DataFactory;
import stream.qns.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Q3_Sprting {
    public static void main(String[] args) {
        List<String> list = DataFactory.products().stream().map(x -> x.getName()).sorted(Comparator.reverseOrder()).toList();
        System.out.println(list);

        List<Integer> sorted = DataFactory.numbers().stream().sorted(Comparator.naturalOrder()).toList();

        List<String> list2 = DataFactory.employees().stream().sorted(
                Comparator.comparing(Employee::getSalary).thenComparing(Employee :: getName)
        ).map(x -> x.getName()).toList();
        System.out.println(list2);

        System.out.println(sorted);
    }
}

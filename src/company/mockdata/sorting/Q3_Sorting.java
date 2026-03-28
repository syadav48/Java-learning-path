package company.mockdata.sorting;

import company.mockdata.DataFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q3_Sorting {
    public static void main(String[] args) {
        List<String> list = DataFactory.getEmployees().stream().sorted(
                Comparator.comparing(x -> x.getSalary())
        ).map(x -> x.getName()).toList();

//        List<String> list1 = DataFactory.getEmployees().stream().sorted(
//                Comparator.comparing(x -> x.getAge()).thenComparing(DataFactory.Employee::getSalary)
//        ).map(x -> x.getName()).toList();
//        System.out.println(list1);

        Optional<String> s = DataFactory.employees().sorted(
                Comparator.comparing(x -> x.getAge())
        ).findFirst().map(x -> x.getName());
        System.out.println(s);

        List<String> list1 = DataFactory.getEmployees().stream().sorted(Comparator.comparing(
                x -> x.getAge(),
                Comparator.reverseOrder()
        )).map(x -> x.getName()).toList();
        System.out.println(list1);
    }
}

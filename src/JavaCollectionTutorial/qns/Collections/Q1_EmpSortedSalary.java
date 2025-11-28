package JavaCollectionTutorial.qns.Collections;

import stream.qns.DataFactory;
import stream.qns.Employee;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Q1_EmpSortedSalary {
    public static void main(String[] args) {
        TreeMap<Double, List<String>> collect = DataFactory.employees().stream().collect(Collectors.groupingBy(
                Employee::getSalary,
                TreeMap::new,
                Collectors.mapping(Employee::getName, Collectors.toList())
        ));
        System.out.println(collect);
    }
}

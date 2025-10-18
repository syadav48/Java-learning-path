package JavaCollectionTutorial.List.Comparator;

import stream.collectors.DataFactory;
import stream.collectors.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Q1_Comparator {
    public static void sortingByLength(List<Employee> list){
        //List<Employee> sorted = list.stream().sorted(Comparator.comparing((x) -> x.getName().length())).toList();
        //list.sort(Comparator.comparing(x -> x.getName().length()));
        Comparator<Employee> bySalary = (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary());
        //Collections.sort(list, bySalary);
        //System.out.println(list);
    }
    public static void sortingBySalaryAndNames(List<Employee> list){
        list.sort(Comparator.comparing(Employee::getSalary).thenComparing((x, y) -> x.getName().compareTo(y.getName())));
        System.out.println(list);
    }
    public static void sortEvenFirst(List<Integer> list){
            List<Integer> list1 = list.stream().filter(x -> x % 2 == 0).sorted().toList();
            List<Integer> list2 = list.stream().filter(x -> x % 2 != 0).sorted().toList();
            List<Integer> list3 = new ArrayList<>();
            list3.addAll(list1);
            list3.addAll(list2);
        //System.out.println(list3);
        Collections.sort(list, (a, b) -> {
            if(a % 2 == 0 && b % 2 != 0) return -1;
            if(a % 2 != 0 && b % 2 == 0) return 1;
            return a - b;
        });
        System.out.println(list);
    }

    public static void main(String[] args) {
        List<Employee> list = DataFactory.getEmployees();
        List<Integer> intList = Arrays.asList(9, 4, 3, 2, 5, 6, 7, 2);
        sortingByLength(list);
        sortingBySalaryAndNames(list);
        sortEvenFirst(intList);
    }
}

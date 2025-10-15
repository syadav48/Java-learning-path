package javamastery.stream.Intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Q6_maxBySalary {
    public static String getMaxSalary(List<Employee> list){
        String max1 = list.stream().collect(Collectors.maxBy(Comparator.comparing(x -> x.getSalary())))
                .map(x -> x.getName())
                .orElse("No Employees");
        String max2 = list.stream().max(Comparator.comparing(Employee::getSalary)).map(x -> x.getName()).orElse("No Employees");
        System.out.println(list.stream().max(Comparator.comparing(x -> x.salary)).map(x -> x.getSalary()));
        System.out.println(list.stream().max(Comparator.comparing(x -> x.salary)).map(x -> x.getSalary()));
        return max2;
    }
    public static void main(String[] args) {
        Employee e1 = new Employee("Suresh", 50000);
        Employee e2 = new Employee("Mahesh", 60000);
        Employee e3 = new Employee("Rakesh", 70000);
        Employee e4 = new Employee("Psh", 80000);
        Employee e5 = new Employee("Rajesh", 90000);
        List<Employee> list = Arrays.asList(e1, e2, e3, e4, e5);
        System.out.println(getMaxSalary(list));
    }

}

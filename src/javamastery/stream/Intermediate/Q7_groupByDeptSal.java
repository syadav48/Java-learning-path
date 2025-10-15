package javamastery.stream.Intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q7_groupByDeptSal {
    public static void groupByDeptSal(List<Employee> list){
        Object obj = list.stream().collect(Collectors.groupingBy(x -> x.department,
                Collectors.averagingDouble(x -> x.salary)));
        System.out.println(obj);
        System.out.println(obj.getClass());
    }
    public static void groupingByDept(List<Employee> list){
        Object obj = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(x -> x.getName(), Collectors.toList())));
        System.out.println(obj);
    }
    public static void main(String[] args) {
        Employee e1 = new Employee("Suresh", 50000, "IT");
        Employee e2 = new Employee("Rajesh", 60000, "HR");
        Employee e3 = new Employee("Rakesh", 70000, "ITIS");
        Employee e4 = new Employee("Mahesh", 80000, "IT");
        Employee e5 = new Employee("Prakash", 90000, "HR");
        Employee e6 = new Employee("Ramesh", 100000, "ITIS");
        List<Employee> list = Arrays.asList(e1, e2, e3, e4, e5, e6);
        groupingByDept(list);
        groupByDeptSal(list);

    }
}

package javamastery.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q3_GroupingBy {
    public static void groupByDepartment(List<Employee> list){
        Map<String, List<Employee>> map = list.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        for(Map.Entry<String, List<Employee>> entry: map.entrySet()){
            System.out.println("department:" + entry.getKey());
            for(Employee employee: entry.getValue()){
                System.out.println("employee");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Employee employee1 = new Employee("Spinning");
        Employee employee2 = new Employee("Textile");
        Employee employee3 = new Employee("IT");
        Employee employee4 = new Employee("Spinning");
        Employee employee5 = new Employee("Spinning");
        List<Employee> lists = Arrays.asList(employee1, employee2, employee3, employee4, employee5);
        groupByDepartment(lists);

    }
}

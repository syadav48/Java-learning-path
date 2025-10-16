package stream.collectors;

import java.net.CookieHandler;
import java.util.*;
import java.util.stream.Collectors;

public class Q1_CollectName {
    public static void collectName(List<Employee> list){
        List<String> list1 = list.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(list1);
    }
    public static void collectDept(List<Employee> list){
        Set<String> set = list.stream().map(Employee::getDepartment).collect(Collectors.toSet());
        System.out.println(set);
    }
    public static void collectEmployee(List<Employee> list){
         String stringList = list.stream().map(Employee::getName).collect(Collectors.joining(", "));
        System.out.println(stringList);
    }
    public static void collectSalaryHR(List<Employee> list){
        list.stream().filter(x -> x.getDepartment().equals("HR")).collect(Collectors.summingDouble(x -> x.getSalary()));
        Double hrSalary = list.stream().filter(x -> x.getDepartment().equals("HR")).mapToDouble(Employee::getSalary).sum();
        System.out.println(hrSalary);
    }
    public static void collectEmployeeIT(List<Employee> list){
       Long list1 = list.stream().map(Employee::getDepartment).filter(x -> x.equals("IT")).count();
       Long list2 = list.stream().filter(e -> e.getDepartment().equals("IT")).collect(Collectors.counting());
        System.out.println(list1);
        System.out.println(list2);
    }
    public static void avgAge(List<Employee> list){
        list.stream().collect(Collectors.averagingInt(x -> x.getAge()));
      Double sumage = list.stream().collect(Collectors.averagingInt(Employee::getAge));
        System.out.println(sumage);
    }
    //here to start:
    public static void maxBy(List<Employee> list){
       Employee maxSalary =  list.stream().collect(Collectors.maxBy(Comparator.comparing(x -> x.getSalary())))
               .orElse(null);
        Employee maxSalaryName =  list.stream().max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
        assert maxSalary != null;
        System.out.println(maxSalary.getName());
    }
    public static void youngestOne(List<Employee> list){
        Employee age =  list.stream().collect(Collectors.minBy(Comparator.comparing(x -> x.getAge())))
                .orElse(null);
        Optional<Employee> youngest =  list.stream().min(Comparator.comparing(Employee::getAge));
        assert age != null;
        System.out.println(youngest);
        System.out.println(age.getName());
    }
    public static void groupByDept(List<Employee> list){
         Map<String, List<String>> map = list.stream().collect(Collectors.groupingBy(x -> x.getDepartment(),
                Collectors.mapping(x -> x.getName(), Collectors.toList())));
        System.out.println(map);
    }
    public static void countByDept(List<Employee> list){
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.counting()));
        System.out.println(map);
    }
    public static void salaryByDept(List<Employee> list){
        Map<String, Double> map = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.summingDouble(x -> x.getSalary())));
        System.out.println(map);
    }
    public static void averageSalaryByDept(List<Employee> list){
        Map<String, Double> map = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(x -> x.getSalary())));
        System.out.println(map);
    }
    public static void groupByCity(List<Employee> list){
        Map<String, List<String>> map = list.stream().collect(Collectors.groupingBy(x -> x.getCity(),
                Collectors.mapping(x -> x.getName(), Collectors.toList())
                ));
        System.out.println(map);
    }
    public static void highestPaid(List<Employee> list){
        Map<String, Optional<Employee>> map = list.stream().collect(Collectors.groupingBy(x -> x.getDepartment(),
                Collectors.maxBy(Comparator.comparingDouble(x -> x.getSalary()))
                ));
        System.out.println(map);
    }
    public static void parttioningEmployee(List<Employee> list){
       Map<Boolean, List<Employee>> map = list.stream().collect(Collectors.partitioningBy(x -> x.isActive()));
        System.out.println(map);
    }
    public static void activeEmployee(List<Employee> list){
        Map<Boolean, Long> map = list.stream().collect(Collectors.partitioningBy(x -> x.isActive(), Collectors.counting()));
        System.out.println(map);
    }
    public static void highestSalary(List<Employee> list){
          String name = list.stream().collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(
                x -> x.getSalary())),
                e -> e.map(x -> x.getName()).orElse(null)
        ));
        System.out.println(name);
    }
    public static void highestPaidEmpName(List<Employee> list){
        Map<String, Object> map = list.stream().collect(Collectors.groupingBy(x -> x.getDepartment(),
               Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(x -> x.getSalary())),
               opt -> opt.map(x -> x.getName()).orElse(null)
               )
        ));
        System.out.println(map);
    }
    public static void groupingByDeptCity(List<Employee> list){
         Map<String, Map<String, List<Employee>>> map = list.stream().collect(Collectors.groupingBy(x -> x.getDepartment(),
                Collectors.groupingBy(x -> x.getCity())
                ));
        System.out.println(map);
    }


    public static void main(String[] args) {
        List<Employee> list = DataFactory.getEmployees();
        collectName(list);
        collectDept(list);
        collectEmployee(list);
        collectEmployeeIT(list);
        collectSalaryHR(list);
        avgAge(list);
        maxBy(list);
        youngestOne(list);
        groupByDept(list);
        countByDept(list);
        salaryByDept(list);
        averageSalaryByDept(list);
        groupByCity(list);
        highestPaid(list);
        parttioningEmployee(list);
        activeEmployee(list);
        highestSalary(list);
        highestPaidEmpName(list);
        groupingByDeptCity(list);
    }
}

package stream.collectors;

import java.util.List;
import java.util.Set;
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
        list.stream().collect(Collectors.averagingInt(x -> x.getAge()));
        Double sumage = list.stream().collect(Collectors.averagingInt(Employee::getAge));
        System.out.println(sumage);
    }

    public static void main(String[] args) {
        List<Employee> list = DataFactory.getEmployees();
        collectName(list);
        collectDept(list);
        collectEmployee(list);
        collectEmployeeIT(list);
        collectSalaryHR(list);
        avgAge(list);
    }
}

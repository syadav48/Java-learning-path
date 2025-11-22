package JavaCollectionTutorial.qns.Map;

import stream.qns.DataFactory;
import stream.qns.Employee;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q5_EmpByDept {
    public static void main(String[] args) {
        Map<String, List<String>> collect = DataFactory.employees().stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.mapping(Employee::getName, Collectors.toList())
        ));

        System.out.println(collect);
    }
}

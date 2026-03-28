package company.mockdata.mapping;

import company.mockdata.DataFactory;

import java.util.List;

public class MappingQns {
    public static void main(String[] args) {
        List<String> list = DataFactory.getEmployees().stream().map(x -> x.getCity()).toList();
        System.out.println(list);

        List<Double> list1 = DataFactory.getEmployees().stream().map(x -> 1.1 * x.getSalary()).toList();
        System.out.println(list1);

        List<Integer> list2 = DataFactory.getEmployees().stream().map(x -> x.getJoiningDate().getYear()).toList();
        System.out.println(list2);
    }
}

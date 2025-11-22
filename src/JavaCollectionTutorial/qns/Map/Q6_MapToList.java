package JavaCollectionTutorial.qns.Map;

import stream.qns.DataFactory;
import stream.qns.Employee;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class Q6_MapToList {

    public static void main(String[] args) {
        List<String> list = DataFactory.employees().stream().map(Employee::getName).toList();
        Map<UUID, Employee> collect = DataFactory.employees().stream().collect(Collectors.toMap(
                x -> UUID.randomUUID(),
                x -> x
        ));
        System.out.println(collect);
    }
}

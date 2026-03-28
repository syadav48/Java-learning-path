package company.mockdata.filtering;

import company.mockdata.DataFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilteredData {
    public static void main(String[] args) {

        List<String> list = DataFactory.getEmployees().stream().filter(x -> x.getSalary() > 100000)
                .map(x -> x.getName()).toList();
        System.out.println(list);


        Map<String, Long> collect = DataFactory.employees().collect(
                Collectors.groupingBy(
                        x -> x.getCity(),
                        Collectors.counting()
                )
        );

        System.out.println(collect);

        List<String> list1 = DataFactory.getTickets().stream().filter(x -> x.getStatus().equals(DataFactory.TicketStatus.OPEN)).map(
                x -> x.getAssignedTo().getName()
        ).toList();

        System.out.println(list1);
    }
}

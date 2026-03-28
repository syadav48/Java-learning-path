package company.mockdata.partitioning;

import company.mockdata.DataFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partitioning {
   public static void main(String[] args) {
       Map<Boolean, List<String>> collect = DataFactory.getEmployees().stream().collect(
               Collectors.partitioningBy(
                       x -> x.getSalary() > 150000,
                       Collectors.mapping(x -> x.getName(), Collectors.toList())
               )
       );
       System.out.println(collect);
   }
}

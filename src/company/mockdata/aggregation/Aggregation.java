package company.mockdata.aggregation;

import company.mockdata.DataFactory;

import java.util.DoubleSummaryStatistics;
import java.util.OptionalDouble;

public class Aggregation {
    public static void main(String[] args) {
        Double reduce = DataFactory.getEmployees().stream().reduce(0.0, (acc, curr) -> acc + curr.getSalary(), Double::sum);
        System.out.println(reduce);
        OptionalDouble average = DataFactory.getEmployees().stream().mapToDouble(x -> x.getSalary()).average();
        System.out.println(average);
        OptionalDouble max = DataFactory.getEmployees().stream().mapToDouble(x -> x.getSalary()).max();
        System.out.println(max);
        DoubleSummaryStatistics statistics = DataFactory.getEmployees().stream().mapToDouble(x -> x.getSalary()).summaryStatistics();
        System.out.println(statistics);
        DataFactory.getProjects().stream().reduce(0.0, (acc, curr) -> acc + curr.getBudget(), Double::sum);
        long count = DataFactory.getTickets().stream().count();
        System.out.println(count);

    }
}

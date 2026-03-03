package stream.practice;

import stream.qns.DataFactory;
import stream.qns.Employee;

public class Q4_Reduce {
    public static void main(String[] args) {
        Integer reduce = DataFactory.numbers().stream().reduce(0, (a, c) -> a + c);
        System.out.println(reduce);

        String reduce1 = DataFactory.sentences().stream().reduce(
                "", (acc, curr) -> acc.length() > curr.length() ? acc : curr
        );
        System.out.println(reduce1);

        Integer reduce2 = DataFactory.numbers().stream().reduce(
                1, (acc, curr) -> acc*curr
        );
        System.out.println(reduce2);

        double maxSalary =
                DataFactory.employees().stream()
                        .map(Employee::getSalary)
                        .reduce(0.0, Double::max);

        System.out.println(maxSalary);
    }
}

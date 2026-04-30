package LTMClinet.streams;

import stream.qns.DataFactory;
import stream.qns.Employee;

import java.util.Collection;
import java.util.Optional;


public class Section8 {
    public static void main(String[] args) {
        Integer reduce = DataFactory.numbers().stream().reduce(0, Integer::sum);
        String s = DataFactory.sentences().stream().reduce("", (acc, curr) -> acc.length() > curr.length() ? acc : curr);
        System.out.println(reduce);
        Integer i1 = DataFactory.numbers().stream().reduce(1, (acc, curr) -> acc * curr);
        System.out.println(s);
        System.out.println(i1);
        Optional<Employee> reduce1 = DataFactory.employees().stream().reduce((acc, curr) -> acc.getSalary() > curr.getSalary() ? acc : curr);
        System.out.println(reduce1.get().getName());

    }
}

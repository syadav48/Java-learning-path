package stream.qns;

import java.util.Arrays;
import java.util.Optional;

public class Q8_Reducing {
    public static void main(String[] args) {
        //1
       int sum = DataFactory.numbers().stream().reduce(0, Integer::sum);
        System.out.println(sum);
        int sum1 = Arrays.stream(DataFactory.numberArray()).reduce(0, Integer::sum);
        System.out.println(sum1);

        //2
        Optional<String> result = DataFactory.sentences().stream().reduce((s1, s2) -> s1.length() >= s2.length() ? s1: s2);
        System.out.println(result);

        //3
         int res = Arrays.stream(DataFactory.numberArray()).reduce(1, (acc, curr) -> acc * curr);
        System.out.println(res);

        Optional<Employee> sal = DataFactory.employees().stream().reduce((s1, s2) -> s1.getSalary() > s2.getSalary() ? s1 : s2);
        System.out.println(sal.map(Employee::getName));


    }
}

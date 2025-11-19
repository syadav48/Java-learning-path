package stream.qns;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Q7_Finding {
    public static void main(String[] args) {
        // 1
        Optional num = DataFactory.numbers().stream().filter(x -> x % 2 == 0).findAny();
        Optional num1 = Arrays.stream(DataFactory.numberArray()).boxed().filter(x -> x % 2 == 0).findFirst();
        System.out.println(num);
        System.out.println(num1);

        //2
        Optional<String> emp = DataFactory.roleToUsers().get("ADMIN").stream().findAny();
        System.out.println(emp);

        //3
         Optional<String> emp1 = DataFactory.employees().stream().filter(x -> x.getSalary() > 10000).map(x -> x.getName())
                .findFirst();
        System.out.println(emp1);

        //4
    }
}

package stream.qns;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Q15_R1Sort {
    public static void main(String[] args) {
        List<String> list = DataFactory.products().stream().sorted(
               Comparator.comparing(
                       Product::getName
               )
        ).map(Product::getName).toList();
        System.out.println(list);

        List<Double> list1 = DataFactory.products().stream().sorted(
                Comparator.comparing(
                        Product::getPrice
                )
        ).map(Product::getPrice).toList();
        System.out.println(list1);

        List<String> list2 = DataFactory.employees().stream().sorted(
                Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()).thenComparing(
                        Employee::getName
                )
        ).map(Employee::getName).toList();
        System.out.println(list2);

        List<LocalDate> list3 = DataFactory.orders().stream().sorted(
                Comparator.comparing(
                        Order::getOrderDate, Comparator.reverseOrder()
                )
        ).map(Order::getOrderDate).toList();
        System.out.println(list3);

        boolean match = DataFactory.employees().stream().allMatch(x -> x.getAge() > 18);
        System.out.println(match);

        Integer integer = DataFactory.numbers().stream().filter(x -> x % 2 == 0).findAny().orElseThrow();
        System.out.println(integer);





    }
}

package stream.qns;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Q16_R1DLS {
    public static void main(String[] args) {
        List<Integer> list = DataFactory.numbers().stream().distinct().toList();
        System.out.println(list);

        List<String> list1 = DataFactory.employees().stream().sorted(
                Comparator.comparing(x -> x.getSalary(), Comparator.reverseOrder())
        ).skip(3).map(x -> x.getName()).limit(2).toList();

        System.out.println(list1);

        List<LocalDate> list3 = DataFactory.orders().stream().sorted(
                Comparator.comparing(
                        Order::getOrderDate, Comparator.reverseOrder()
                )
        ).map(Order::getOrderDate).toList();

        System.out.println(list3);

        Optional<String> admin = DataFactory.roleToUsers().get("ADMIN").stream().findAny();
        System.out.println(admin);
    }
}

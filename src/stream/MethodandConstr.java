package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodandConstr {
    public static void main(String[] args) {
        //Method Reference: use method without invoking & in place of lamda expression
        //Use the method println of System.out on each element

        List<String> students = Arrays.asList("Ram", "Shyam", "Ghanshyam");
        students.forEach(x -> System.out.println(x));
        students.forEach(System.out::println);

        // constructor reference
        List<String> names = Arrays.asList("A", "B", "C");
        List<MobilePhone> mobilePhoneList = names.stream().map(MobilePhone::new).collect(Collectors.toList());

    }

}

class  MobilePhone{
    String name;

    public MobilePhone(String name) {
        this.name = name;
    }
}

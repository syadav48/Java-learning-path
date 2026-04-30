package LTMClinet.streams;

import stream.qns.DataFactory;
import stream.qns.Employee;

public class Section7 {
    public static void main(String[] args) {
        Integer i1 = DataFactory.numbers().stream().filter(x -> x % 2 == 0).findFirst().orElseThrow();
        String s1 = DataFactory.roleToUsers().get("ADMIN").stream().findAny().get();
        Employee employee = DataFactory.employees().stream().filter(x -> x.getSalary() > 100000).findFirst().orElseThrow();
        System.out.println(employee.getName());

        System.out.println(i1);
        System.out.println(s1);
    }
}

package stream.InterviewPractice;


import stream.qns.DataFactory;
import stream.qns.Employee;
import stream.qns.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q2_filtering {
    public static boolean isPrime(int n){
        if(n == 1 || n == 2 || n == 3) return true;
        if(n % 2 == 0) return false;
        for(int i = 3; i <= Math.sqrt(n); i = i+2){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        List<Integer> numbers = DataFactory.numbers();
        List<Integer> list = numbers.stream().filter(Q2_filtering::isPrime).toList();
        System.out.println(list);

        List<String> list1 = DataFactory.employees().stream().filter(x -> x.getSalary() > 0)
                        .map(Employee::getName).toList();

        System.out.println(list1);

        Stream<Optional<String>> list2 = DataFactory.optionalStrings().stream().filter(x -> x.isPresent());
        System.out.println(list2.toList());

        List<String> list3 = DataFactory.transactions().stream().filter(x -> x.getType().equals(Transaction.Type.CREDIT))
                .map(x -> x.getTxnId()).toList();

        System.out.println(list3);

        List<String> list4 = DataFactory.employees().stream().map(x -> x.getName().toUpperCase()).toList();

        System.out.println(list4);

       List<String> lists = List.of("Java is awesome", "I practice streams");

        List<String> list5 = lists.stream().map(x -> x.split(" "))
                .flatMap(Arrays::stream).toList();
        System.out.println(list5);

        List<String> list6 = DataFactory.employees().stream().map(x -> x.getSkills())
                .flatMap(x -> x.stream().distinct()).toList();

        System.out.println(list6);

    }
}

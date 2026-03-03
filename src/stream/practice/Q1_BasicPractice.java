package stream.practice;

import stream.qns.DataFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q1_BasicPractice {
    public static boolean isPrime(int num){
        if(num <= 1) return false;
        if(num == 2 || num == 3)  return true;
        if(num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i*i <= num ; i += 6) {
            if(num % i == 0 || num % (i + 2) == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Map<Boolean, List<Integer>> collect = DataFactory.numbers().stream()
                .collect(Collectors.groupingBy(
                        Q1_BasicPractice::isPrime
                ));
        List<Integer> list = DataFactory.numbers().stream().filter(x -> isPrime(x)).toList();

        List<String> list1 = DataFactory.employees().stream().filter(x -> x.getSalary() > 50000).map(x -> x.getName()).toList();
        System.out.println(collect);
        System.out.println(list);
        System.out.println(list1);

        List<String> list2 = DataFactory.sentences().stream().map(x -> x.split(" "))
               .flatMap(Stream::of).toList();
        System.out.println(list2);

        List<String> list3 = DataFactory.employees().stream().map(x -> x.getSkills())
                .flatMap(x -> x.stream()).distinct().toList();
        System.out.println(list3);

    }

}

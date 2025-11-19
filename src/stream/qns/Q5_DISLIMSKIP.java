package stream.qns;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Q5_DISLIMSKIP {
    public static void main(String[] args) {
        //1
        List<Integer> list = DataFactory.numbers().stream().distinct().toList();
        System.out.println(list);

        //2
        List<String> list1 = DataFactory.employees().stream().sorted(Comparator.comparing(Employee :: getSalary).reversed())
                .map(Employee::getName).limit(3).toList();
        System.out.println(list1);
//        ***** *****
        PriorityQueue<Employee> pq = new PriorityQueue<>(Comparator.comparing(Employee::getSalary).reversed());

        pq.addAll(DataFactory.employees());

         List<String> top3 = IntStream.range(0, 3).mapToObj(x -> pq.poll().getName()).toList();
        System.out.println(top3);

        List<String> list2 = DataFactory.employees().stream().skip(5).map(Employee::getName).toList();
        System.out.println(list2);

        System.out.println(Arrays.toString(IntStream.range(0, 9).limit(4).toArray()));

        Stream<Integer> intValues = Stream.generate(() -> new Random().nextInt()).limit(10);
        System.out.println(Arrays.toString(intValues.toArray()));


    }
}

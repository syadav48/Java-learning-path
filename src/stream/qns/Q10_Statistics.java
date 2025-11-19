package stream.qns;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q10_Statistics {
    public static void main(String[] args) {
        //1
        Integer min = DataFactory.numbers().stream().min(Comparator.comparing(x -> x)).orElseThrow();
        Optional<Integer> max = DataFactory.numbers().stream().min(Comparator.comparing(x -> x));
        int sum = DataFactory.numbers().stream().mapToInt(x -> x).sum();
        OptionalDouble avg = DataFactory.numbers().stream().mapToInt(x -> x).average();
        System.out.println(min + " " + max + " " + sum + " " + avg);

        IntStream stream = Arrays.stream(DataFactory.numberArray());
        int min1 = stream.min().orElseThrow();
        stream = Arrays.stream(DataFactory.numberArray());
        int max1 = stream.max().orElseThrow();
        stream = Arrays.stream(DataFactory.numberArray());
        int sum1 = stream.sum();
        stream = Arrays.stream(DataFactory.numberArray());
        double avg1 = stream.average().orElseThrow();

        System.out.println(min1 + " " + max1 + " " + sum1 + " " + avg1);

        IntSummaryStatistics stream1 = DataFactory.numbers().stream().mapToInt(x -> x).summaryStatistics();

        System.out.println(stream1.getMax() + " " + stream1.getMin() + " " + stream1.getSum() + " " + stream1.getAverage() + " " + stream1.getCount());

        //2
        DoubleSummaryStatistics statistics = DataFactory.employees().stream().mapToDouble(x -> x.getSalary()).summaryStatistics();

        System.out.println(statistics.getSum() + " " + statistics.getAverage());

        //3
        long count = DataFactory.employees().stream().filter(x -> x.getName().startsWith("S")).count();
        System.out.println(count);



    }
}

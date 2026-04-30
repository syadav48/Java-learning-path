package LTMClinet.streams;

import stream.qns.DataFactory;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

public class Section10 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        int asInt = DataFactory.numbers().stream().mapToInt(x -> x).sum();
        double sum = DataFactory.employees().stream().mapToDouble(x -> x.getSalary()).sum();
        System.out.println(asInt);
        System.out.println(sum);
        double asDouble = DataFactory.employees().stream().mapToDouble(x -> x.getSalary()).average().getAsDouble();
        System.out.println(asDouble);
        Map<Boolean, Long> s = DataFactory.employees().stream().collect(Collectors.groupingBy(
                x -> x.getName().startsWith("S"),
                Collectors.counting()
        ));
        System.out.println(s);
    }
}

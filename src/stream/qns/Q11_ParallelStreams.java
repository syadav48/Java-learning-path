package stream.qns;

import javamastery.stream.ParallelStreamDemo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Q11_ParallelStreams {
    public static Integer sumParrallel(List<Integer> list){
        return list.parallelStream().reduce(0, Integer::sum);
    }
    public static Integer sequentialParrallel(List<Integer> list){
        return list.stream().reduce(0, Integer::sum);
    }
    public static void main(String[] args) {
        // 1
        List<Integer> list = IntStream.range(1, 100000).boxed().toList();

        long startTime = System.currentTimeMillis();
        Integer parallelSum = sumParrallel(list);
        long parallelTime = System.currentTimeMillis() - startTime;

        long startSeqTime = System.currentTimeMillis();
        Integer seqSum = sequentialParrallel(list);
        long seqTime = System.currentTimeMillis() - startSeqTime;

        System.out.println("Parallel sum: " + parallelSum + " Time: " + parallelTime + "ms");
        System.out.println("Sequential sum: " + seqSum + " Time: " + seqTime + "ms");

        //2:
        List<Integer> list1 = DataFactory.numbers().parallelStream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(list1);



    }
}

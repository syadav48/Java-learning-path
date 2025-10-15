package javamastery.stream;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamDemo {
    public static Integer sumParallel(List<Integer> list){
        return list.parallelStream().reduce(0, Integer::sum);
    }

    public static Integer sumSequential(List<Integer> list){
        return list.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        // Create a large list for testing
        List<Integer> largeList =  IntStream.range(0, 1000000)
                .boxed()
                .collect(Collectors.toList());

        long startTime = System.currentTimeMillis();
        Integer parallelSum = sumParallel(largeList);
        long parallelTime = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        Integer sequentialSum = sumSequential(largeList);
        long sequentialTime = System.currentTimeMillis() - startTime;

        System.out.println("Parallel sum: " + parallelSum + " Time: " + parallelTime + "ms");
        System.out.println("Sequential sum: " + sequentialSum + " Time: " + sequentialTime + "ms");
    }
}

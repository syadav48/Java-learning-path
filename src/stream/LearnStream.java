package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LearnStream {
    //feature introduced in Java 8
    // process collection of data in a functional and declarative mannner
    // Simplify data processing
    // Embrace Functional Programming
    // Improve Readability and maintainability
    // Enable Easy Parallelism

    // What is stream?
    // a sequence of elements supporting functional and declarative programming
    // How to use stream?
    // Source, intermediate operations, & terminal operation
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list.stream().filter(x -> x % 2 == 0).count());

        // Creating Streams
        // 1. From Collections:
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        // 2. From Arrays:
        String[] array = {"a", "b", "x"};
        Stream<String> stream1 = Arrays.stream(array);

        // 3. Using Stream Of:
        Stream<String> stream2 = Stream.of("a", "b");

        //4. Infinite Streams
        Stream<Integer> generate = Stream.generate(() -> 1);
        List<Integer> collect = Stream.iterate(1, x -> x + 1).limit(100).collect(Collectors.toList());

    }




}

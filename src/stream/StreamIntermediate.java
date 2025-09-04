package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamIntermediate {
    public static void main(String[] args) {
        // Intermediate Operations transform a stream into another stream
        //They are lazy, meaning they don't execute until a terminal operation is invoked

        //1. filter
        List<String> list = Arrays.asList("Sangita", "Sunita", "Sarita", "Anurag");
        Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("S"));
        // no filtering at this point
        long count = filteredStream.count();
        System.out.println(count);

        // 2. Map
        Stream<String> stringStream = list.stream().map(String::toUpperCase);

        //3 . sorted
        Stream<String> sorted = list.stream().sorted();
        Stream<String> sorted1 = list.stream().sorted((a, b) -> a.length() - b.length());

        // 4. distinct
        long a = list.stream().filter(x -> x.startsWith("A")).distinct().count();

        //5. limit
        long count1 = Stream.iterate(1, x -> x + 1).limit(100).count();
        System.out.println(count1);
        //6. skip
        long count2 = Stream.iterate(1, x -> x + 1).skip(10).limit(100).count();
        System.out.println(count2);

        //7. peek
        Stream.iterate(1, x -> x + 1).skip(10).limit(100).peek(System.out::println).count();

        // 8. flatMap
        // Handle streams of collections, lists, or arrays where each element is itself a collection
        // Flatten nested structures (e.g., lists within lists) so that they can be processed as a single sequence of elements
        // Transform and flatten elements at the same time.
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape")
        );
        System.out.println(listOfLists.get(1).get(1));
        System.out.println(listOfLists.stream().flatMap(Collection::stream).map(String::toUpperCase).toList());

        List<String> sentences = Arrays.asList(
                "Hello world",
                "Java streams are powerful",
                "flatMap is useful"
        );
        System.out.println(sentences
                .stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toUpperCase)
                .toList());
    }

}

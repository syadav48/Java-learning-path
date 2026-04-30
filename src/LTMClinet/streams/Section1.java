package LTMClinet.streams;

import company.mockdata.DataFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Section1 {
   public static void main(String[] args) {
       List<Integer> numbers = Arrays.asList(1,2,3,4,5);
       int[] arr = {3, 6, 11, 20, 41};
       numbers.forEach(x -> System.out.println(x.toString()));
       int[] array = Arrays.stream(arr).filter(x -> x % 2 == 0).boxed().mapToInt(x -> x.intValue()).toArray();
       System.out.println(Arrays.toString(array));
       Stream<String> s1 = Stream.of("A","B");
       Stream<String> s2 = Stream.of("C","D");
       String collect = Stream.concat(s1, s2).collect(Collectors.joining(""));
       System.out.println(collect);

   }
}

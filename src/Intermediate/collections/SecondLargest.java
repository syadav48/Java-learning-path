package Intermediate.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SecondLargest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 5, 8, 9, 10, 16, 19);
          Integer secondLargest1 = list.stream().sorted().toList().get(list.size() - 2);
          Integer secondLargest2 = list.stream()
                  .sorted(Comparator.reverseOrder())
                  .skip(1)
                  .findFirst().orElse(null);
          
        System.out.println(secondLargest1 + " " + secondLargest2);
    }
}

package stream.practice;

import java.util.*;

public class BasicStream {
    public static void main(String[] args) {
        int [] list = {1, 4, 7, 8, 3, 23, 45, 66, 78, 90, 8, 3, 23, 1001};
        List<Integer> nums = new ArrayList<>();
        List<String> names = Arrays.asList("Surya", "Manish", "Ansul", "Nawneet", "Nitish", "Surya");
        for (int i = 1; i < 10; i++) {
            nums.add(i);
        }
        List<Integer> arr = nums.stream().map(x -> x * x).toList();
        System.out.println(arr);
        System.out.println(nums);
        Optional<Integer> max = nums.stream().max(Comparator.naturalOrder());
        Integer min = nums.stream().min(Comparator.naturalOrder()).get();

        System.out.println(max + " " + min);

        List<Integer> stream = Arrays.stream(list).filter(x -> x % 2 == 0)
                .boxed()
                .toList();
        System.out.println(stream);

        List<String> filtered = names.stream().filter(x -> !x.startsWith("A")).toList();
        System.out.println(filtered);
        List<String> dist = names.stream().distinct().toList();
        System.out.println(dist);
        List<Integer> sorted = Arrays.stream(list).boxed().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sorted);
        boolean greater100 = Arrays.stream(list).boxed().anyMatch(x -> x > 100);
        System.out.println(greater100);
        Arrays.stream(list).boxed().forEach(System.out::println);


    }
}

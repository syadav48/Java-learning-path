import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streama {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 8,3,5,9,12);
        int sum = 0;
        for(int n: nums)
        {
            if(n % 2 == 0)
            {
                n = n * 2;
                sum = sum + n;
            }
        }
        System.out.println(sum);

        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));   
        }
        for (Integer n : nums) {
            System.out.println(n);
        }
        nums.forEach(n -> System.out.println(n));

        Stream<Integer> s1 = nums.stream();
        Stream<Integer> s2 = s1.filter(n -> n%2 == 0);
        Stream<Integer> s3 = s2.map(n -> n * 2);
        int result = s3.reduce(0, (c, e) -> c + e);
        int finalResult = nums.stream().filter(n -> n%2 == 0).map(n -> n * 2).reduce(0, (c, e) -> c + e);
        // s1 can be modified without affecting the original array
        //s1.forEach(n -> System.out.println(n));
        // stream can be used only once

        System.out.println(result);
        System.out.println(finalResult);
        System.out.println(nums.stream());
    }
}

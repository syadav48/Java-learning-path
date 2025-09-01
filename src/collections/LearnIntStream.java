package collections;

import java.util.Arrays;

public class LearnIntStream {
    public static void main(String[] args) {
        int [] nums = {9, 10, 34, 56, 89, 21, 3, 2};
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));

    }
}

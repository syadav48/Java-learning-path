package collections;

import java.util.Arrays;

public class LearnArraysClass {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int [] nums = {12, 43, 1, 020, 22, 45};
        int [] rows = {12, 43, 1, 020, 22, 45};

        int index = Arrays.binarySearch(numbers, 4);

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        Arrays.fill(nums, 9);
        Arrays.parallelSort(numbers);
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("The index of element 4 in the array is " + index);
    }
}

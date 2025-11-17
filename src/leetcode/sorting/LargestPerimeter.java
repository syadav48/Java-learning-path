package leetcode.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LargestPerimeter {
    public LargestNumber largestNumber = new LargestNumber();
    public int largestPerimeter(int[] nums) {
       int d = largestNumber.dominantIndex(nums);
        System.out.println(d);
        Arrays.sort(nums);
        int a = 0;
        int b = 0;
        int c = 0;
        int i = nums.length - 1;
        while (i >= 2){
            if(nums[i-1] + nums[i-2] > nums[i]){
                a = nums[i];
                b = nums[i - 1];
                c = nums[i - 2];
                System.out.println(a + " " + b + " " + c);
                return a + b + c;
            }
            i--;
        }
       return 0;
    };
    public static void main(String[] args) {
        int[] nums1 = {2,1,2};
        int[] nums2 = {1,2,1,10};
        int[] nums3 = {3,6,2,3};
        LargestNumber largestNumber1 = new LargestNumber();
        System.out.println(largestNumber1.dominantIndex(nums3));
        LargestPerimeter largestPerimeter = new LargestPerimeter();
        System.out.println(largestPerimeter.largestPerimeter(nums1));
        System.out.println(largestPerimeter.largestPerimeter(nums2));
        System.out.println(largestPerimeter.largestPerimeter(nums3));
    }

    public static class FindEvenNo {
        public int[] findEvenNumbers(int[] digits) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < digits.length; i++) {
                for (int j = 0; j < digits.length; j++) {
                    for (int k = 0; k < digits.length; k++) {
                        if(k != j && k != i && j != i && digits[i] != 0){
                            StringBuilder str = new StringBuilder();
                            str.append(digits[i]);
                            str.append(digits[j]);
                            str.append(digits[k]);
                            int num = Integer.parseInt(str.toString());
                            if(num % 2 == 0){
                                list.add(num);
                            }
                        }
                    }
                }

            }
            return list.stream().distinct().sorted().mapToInt(x -> x.intValue()).toArray();
        }
        public int[] findEvenNumber(int[] digits){
            int[] freq = new int[10];
            for (int d: digits){
                freq[d]++;
            }
            List<Integer> list = new ArrayList<>();
            for (int num = 100; num < 1000; num += 2) {
                int a = num / 100;
                int b = (num/10) % 10;
                int c = num % 10;
                System.out.println(a + freq[a]);
                freq[a]--;
                freq[b]--;
                freq[c]--;
                if (freq[a] >= 0 && freq[b] >= 0 && freq[c] >= 0) {
                    list.add(num);
                }
                freq[a]++; freq[b]++; freq[c]++;
            }
            return list.stream().mapToInt(i -> i).toArray();
        }
        public static void main(String[] args) {
            int[] digits = {2,1,3,0};
            FindEvenNo findEvenNo = new FindEvenNo();
            System.out.println(Arrays.toString(findEvenNo.findEvenNumber(digits)));
        }


    }
}

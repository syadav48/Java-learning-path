package helloInterview.dsa.problems.hashPrefix;

import java.util.*;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int longest  = 0;
        for (int num: set){
            if(!set.contains(num - 1)){
                int currentNum = num;
                int streak = 1;
                while (set.contains(currentNum + 1)){
                    currentNum++;
                    streak++;
                }
                longest = Math.max(longest, streak);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int[] nums = {1,0,1,2};
        System.out.println(longestConsecutive.longestConsecutive(nums));
    }
}

package helloInterview.dsa.problems.hashPrefix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;
            if(map.containsKey(sum)){
                maxLength = Math.max(
                        maxLength,
                        i - map.get(sum)
                );
            } else {
                map.put(sum, i);
            }
        }
        System.out.println(map);
        return maxLength;

    }
    public static void main(String[] args) {
     ContiguousArray contiguousArray = new ContiguousArray();
     int[] nums = {0,1,1,1,1,1,0,0,0};
        System.out.println(contiguousArray.findMaxLength(nums));
    }
}

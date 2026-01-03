package leetcode.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class SumOfElement {
    public int sumDivisibleByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
           if(entry.getValue() % k == 0){
               list.add(entry.getKey()*entry.getValue());
           }
       }
        return list.stream().reduce(0, Integer::sum);
    };
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,3,3,4};
        SumOfElement sumOfElement = new SumOfElement();
        System.out.println(sumOfElement.sumDivisibleByK(nums, 2));
    }
}

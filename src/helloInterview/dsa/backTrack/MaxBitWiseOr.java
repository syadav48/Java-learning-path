package helloInterview.dsa.backTrack;

import java.util.*;

public class MaxBitWiseOr {
    private int maxOR = 0;
    private int maxCount = 0;
    private int findBit(List<Integer> nums){
        int or = 0;
        for(int num: nums){
            or = or | num;
        }
        return or;
    }
    public int countMaxOrSubsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 1){
            return 1;
        }

        backTrackMaxSubsets(nums, 0, new ArrayList<>(), res);
        System.out.println(res);
        return maxCount;
    }

    private void backTrackMaxSubsets(int[] nums, int start, List<Integer> paths, List<List<Integer>> res) {

        if(!paths.isEmpty()){
           int localOR = findBit(paths);
            if(localOR == maxOR){
                maxCount++;
            }else if(localOR > maxOR) {
                maxOR = localOR;
                maxCount = 1;
            }

            res.add(new ArrayList<>(paths));
        }
        //tracking the maximum OR while generating subsets.
        for(int i = start; i < nums.length; i++){
            paths.add(nums[i]);

            backTrackMaxSubsets(
                    nums,
                    i+1,
                    paths,
                    res
            );

            paths.remove(paths.size() - 1);
        }

    }

    public static void main(String[] args) {
        MaxBitWiseOr maxBitWiseOr = new MaxBitWiseOr();
        int[] nums = {1,2,3};
        List<Integer> list = List.of(1,2,3);
        System.out.println(maxBitWiseOr.countMaxOrSubsets(nums));
       // System.out.println(maxBitWiseOr.findBit(list));
        System.out.println(88 | 0);

    }
}

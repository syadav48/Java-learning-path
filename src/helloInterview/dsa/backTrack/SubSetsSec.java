package helloInterview.dsa.backTrack;

import leetcode.string.Subsets;

import java.util.ArrayList;
import java.util.List;

public class SubSetsSec {
    private List<List<Integer>> result;
    private int[] nums;
    public List<List<Integer>> subsetsWith(int[] nums) {
        this.nums = nums;
        this.result = new ArrayList<>();
        dfs(0, new ArrayList<>());
        return result;
    }

    private void dfs(int index, List<Integer> path) {
        System.out.println(index +" path:"  + path);
        if(index == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        dfs(index + 1, path);
        path.remove(path.size() - 1);
        dfs(index + 1, path);
    }

    public static void main(String[] args) {
        SubSetsSec subsets = new SubSetsSec();
        int[] nums = {1, 2};
        System.out.println(subsets.subsetsWith(nums));
    }
}

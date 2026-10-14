package helloInterview.dsa.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        backTrackSumII(candidates, target, 0, path, result);
        return result;
    }

    private void backTrackSumII(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result) {
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        System.out.println(path);
        for (int i = start; i < candidates.length; i++) {
            // add
            if(i > start && candidates[i-1] == candidates[i]){
                continue;
            }
            if (candidates[i] > target) break;
            path.add(candidates[i]);
            // explore
            backTrackSumII(candidates, target - candidates[i], i + 1, path, result);

            // undo
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        int[] candidates = {10,1,2,7,6,1,5};
        System.out.println( combinationSumII.combinationSum2(candidates, 8));
    }
}

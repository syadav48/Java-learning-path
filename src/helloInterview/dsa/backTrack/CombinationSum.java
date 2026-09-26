package helloInterview.dsa.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backTrack(candidates, target, 0, new ArrayList<>(), result);
        return result;

    }

    private void backTrack(int[] candidates, int target, int start, List<Integer> combo, List<List<Integer>> result) {
        if(target == 0){
            result.add(new ArrayList<>(combo));
            return;
        }
        for (int i = start; i < candidates.length ; i++) {
            int curr = candidates[i];
            if(candidates[i] > target){
                return;
            }
            combo.add(curr);
            backTrack(candidates, target-curr, i, combo, result);
            combo.remove(combo.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2,3,6,7};
        System.out.println(combinationSum.combinationSum(candidates, 7));
    }
}

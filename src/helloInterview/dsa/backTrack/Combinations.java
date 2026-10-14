package helloInterview.dsa.backTrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrackComb(n, k, path, 1, result);
        return result;

    }

    private void backTrackComb(int n, int k, List<Integer> path, int start, List<List<Integer>> result) {
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++){
            // add
            path.add(i);
            // explore
            backTrackComb(n, k, path, i + 1, result);
            // undo
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        int n = 4;
        int k = 2;
        System.out.println(combinations.combine(n, k));
    }
}

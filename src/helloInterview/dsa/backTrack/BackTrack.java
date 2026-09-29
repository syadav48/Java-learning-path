package helloInterview.dsa.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BackTrack {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;

    }


    private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            // choose:
            path.add(nums[i]);
            // explore:
            backtrack(nums, i + 1, path, res);

            // undo:
            path.remove(path.size() - 1);
        }
    }
    private void backtrackWTDup(
            int[] nums,
            int start,
            List<Integer> path,
            List<List<Integer>> result) {

        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            // i > start
            //Skip duplicate choices at the same recursion level.
            if (i > start &&
                    nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);

            backtrackWTDup(
                    nums,
                    i + 1,
                    path,
                    result
            );

            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrackPerm(
                nums,
                used,
                new ArrayList<>(),
                result
        );
        return result;
    }

    private void backtrackPerm(
            int[] nums,
            boolean[] used,
            List<Integer> path,
            List<List<Integer>> result) {

        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // Choose
            System.out.println(Arrays.toString(used) + used[i]);
            used[i] = true;
            path.add(nums[i]);

            // Explore
            backtrackPerm(
                    nums,
                    used,
                    path,
                    result
            );

            // Undo
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> combinationSum(
            int[] candidates,
            int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrackSum(
                candidates,
                target,
                0,
                new ArrayList<>(),
                result
        );

        return result;
    }

    private void backtrackSum(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result){
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //choose
            path.add(candidates[i]);

            //explore
            backtrackSum(candidates, target-candidates[i], i, path, result);
            // can reuse current element: -

            // undo
            path.remove(path.size() - 1);
        }
    }
    private boolean dfs(
            char[][] board,
            String word,
            int r,
            int c,
            int index) {

        if (index == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length ||
                c < 0 || c >= board[0].length ||
                board[r][c] != word.charAt(index)) {

            return false;
        }

        char original = board[r][c];

        board[r][c] = '#';

        boolean found =
                dfs(board, word, r + 1, c, index + 1)
                        || dfs(board, word, r - 1, c, index + 1)
                        || dfs(board, word, r, c + 1, index + 1)
                        || dfs(board, word, r, c - 1, index + 1);

        board[r][c] = original;

        return found;
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        boolean[] cols = new boolean[n];

        boolean[] diag1 = new boolean[2 * n - 1];

        boolean[] diag2 = new boolean[2 * n - 1];

        backtrackNQueen(
                0,
                n,
                board,
                cols,
                diag1,
                diag2,
                result
        );

        return result;
    }

    private void backtrackNQueen(
            int row,
            int n,
            char[][] board,
            boolean[] cols,
            boolean[] diag1,
            boolean[] diag2,
            List<List<String>> result) {

        // All rows successfully filled
        if (row == n) {

            List<String> solution = new ArrayList<>();

            for (char[] r : board) {
                solution.add(new String(r));
            }

            result.add(solution);

            return;
        }

        for (int col = 0; col < n; col++) {

            int d1 = row - col + n - 1;
            int d2 = row + col;

            // PRUNING
            if (cols[col] ||
                    diag1[d1] ||
                    diag2[d2]) {

                continue;
            }

            // CHOOSE
            board[row][col] = 'Q';

            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            // EXPLORE
            backtrackNQueen(
                    row + 1,
                    n,
                    board,
                    cols,
                    diag1,
                    diag2,
                    result
            );

            // UNDO
            board[row][col] = '.';

            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    public boolean solveSudoku(char[][] board) {

        return solve(board);
    }

    private boolean solve(char[][] board) {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (board[row][col] != '.') {
                    continue;
                }

                for (char num = '1'; num <= '9'; num++) {

                    if (!isValid(board, row, col, num)) {
                        continue;
                    }

                    // CHOOSE
                    board[row][col] = num;

                    // EXPLORE
                    if (solve(board)) {
                        return true;
                    }

                    // UNDO
                    board[row][col] = '.';
                }

                // No number worked
                return false;
            }
        }

        // No empty cells
        return true;
    }

    private boolean isValid(
            char[][] board,
            int row,
            int col,
            char num) {

        for (int i = 0; i < 9; i++) {

            // Row
            if (board[row][i] == num) {
                return false;
            }

            // Column
            if (board[i][col] == num) {
                return false;
            }

            // 3x3 box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;

            if (board[boxRow][boxCol] == num) {
                return false;
            }
        }

        return true;
    }

    //Knight's Tour algorithm:

//    public void boolean solve(
//            int[][] board,
//            int row,
//            int col,
//            int move) {
//
//        if (move == n * n) {
//            return true;
//        }
//
//        for (int i = 0; i < 8; i++) {
//
//            int nextRow = row + dr[i];
//            int nextCol = col + dc[i];
//
//            if (!isSafe(nextRow, nextCol)) {
//                continue;
//            }
//
//            board[nextRow][nextCol] = move;
//
//            if (solve(
//                    board,
//                    nextRow,
//                    nextCol,
//                    move + 1)) {
//
//                return true;
//            }
//
//            board[nextRow][nextCol] = -1;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        BackTrack backTrack = new BackTrack();
        int[] nums = {1,2,3};
        int[] candidates = {2,3,6,7};
        System.out.println(backTrack.subsets(nums));;
        System.out.println(backTrack.permute(nums));
        System.out.println(backTrack.combinationSum(candidates, 7));
    }
}

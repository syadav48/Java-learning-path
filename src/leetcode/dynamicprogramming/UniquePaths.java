package leetcode.dynamicprogramming;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] count = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.out.println(i);
        }
        return 5;
    };
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(m, n));
    }
}

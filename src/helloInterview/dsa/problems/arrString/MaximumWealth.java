package helloInterview.dsa.problems.arrString;

import java.util.Arrays;

public class MaximumWealth {
    public int maximumWealth(int[][] accounts) {
        //return Arrays.stream(accounts).map(x -> Arrays.stream(x).reduce(0, Integer::sum)).mapToInt(x -> x).max().orElse(0);
        int[] res = new int[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            res[i] = Arrays.stream(accounts[i]).sum();
        }
        return Arrays.stream(res).max().orElse(0);

    }
    public int maximumWealthOpt(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            max  = Math.max(max, sum);
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] accounts = {{1,5},{7,3},{3,5}};
        MaximumWealth maximumWealth = new MaximumWealth();
        System.out.println(maximumWealth.maximumWealthOpt(accounts));
    }
}

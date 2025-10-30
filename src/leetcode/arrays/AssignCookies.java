package leetcode.arrays;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        int sum = Arrays.stream(s).boxed().reduce(0, Integer::sum);
        int count = 0;
        int[] res = Arrays.stream(g).boxed().sorted().mapToInt(x -> x).toArray();
        for(int i = 0; i < res.length; i++){
            if(sum - res[i] > 0){
                count++;
                sum -= res[i];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        int[] g1 = {10,9,8,7};
        int[] s1 = {5,6,7,8};
        System.out.println(findContentChildren(g1, s1));
    }
}

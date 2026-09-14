package helloInterview.dsa.greedyAlgo;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, count = 0;
        while (i < g.length && j < s.length){
            if(s[j] >= g[i]){
                i++;
                count++;
            }
            j++;
        }
        return count;
    }
    public static void main(String[] args) {
        AssignCookies cookies = new AssignCookies();
        int[] g = {1,3,3,4};
        int[] s = {2,2,3,4};
        System.out.println(cookies.findContentChildren(g, s));
    }
}

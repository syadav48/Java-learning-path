package leetcode.string;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxSubstring {
    public int maxDistinct(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        long count = Arrays.stream(freq).boxed().filter(x -> x > 0).count();
        return Math.toIntExact(count);
    }
    public int optimizedMaxDistinct(String s) {
        Map<Character, Long> collect = s.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return collect.size();
    }
    public static void main(String[] args) {
        MaxSubstring maxSubstring = new MaxSubstring();
        String str = "abbc";
        System.out.println(maxSubstring.optimizedMaxDistinct(str));
    }
}

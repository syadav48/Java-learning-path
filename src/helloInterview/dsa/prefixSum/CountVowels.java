package helloInterview.dsa.prefixSum;

import java.util.Arrays;
import java.util.Set;

public class CountVowels {
    public int[] vowelStrings(String word, int[][] queries) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int[] prefixSum = new int[word.length() + 1];
        for (int i = 1; i <= word.length(); i++) {
            boolean isVowel = vowels.contains(word.charAt(i - 1));
            prefixSum[i] = prefixSum[i - 1] + (isVowel ? 1 : 0);
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = prefixSum[queries[i][1] + 1] - prefixSum[queries[i][0]];
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
    public static void main(String[] args) {
        CountVowels countVowels = new CountVowels();
        String word = "picture";
        int[][] queries = {{0,2}, {1,4}, {3, 5}};
        countVowels.vowelStrings(word, queries);
    }
}

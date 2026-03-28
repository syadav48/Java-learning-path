package leetcode.leet75.arrstr;

public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        int first = 0;
        int second = 0;
        StringBuilder str = new StringBuilder();
        while (first < word1.length() && second < word2.length()){
            str.append(word1.charAt(first));
            str.append(word2.charAt(second));
            first++;
            second++;
        }
        while (first < word1.length()){
            str.append(word1.charAt(first));
            first++;
        }
        while (second < word2.length()){
            str.append(word2.charAt(second));
            second++;
        }
        return str.toString();

    };
    public static void main(String[] args) {
        MergeAlternately merge = new MergeAlternately();
        String s1 = "abcd";
        String s2 = "pq"; //apbqcr
        System.out.println(merge.mergeAlternately(s1, s2));
    }
}

package helloInterview.dsa.problems.arrString;

public class FirstIndexString {
    public int strStr(String haystack, String needle) {
        int k = needle.length();
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (i - j + 1 == k) {
                System.out.println(haystack.substring(j, i + 1));
                if (haystack.substring(j, i + 1).equals(needle)) {
                    return j;
                }
                j++;
            }
        }
        return -1;
    }

    public int strStrOpt(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int[] lps = buildLPS(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {

            if (haystack.charAt(i) == needle.charAt(j)) {

                i++;
                j++;

                if (j == needle.length()) {
                    return i - j;
                }

            } else {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;

    }

    private int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        FirstIndexString firstIndexString = new FirstIndexString();
        String h = "leetcode";
        String n = "leeto";
        System.out.println(firstIndexString.strStrOpt(h, n));
    }
}

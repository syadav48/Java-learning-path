package helloInterview.dsa.problems.slidingWindow;

public class MinWindowString {
    public String minWindow(String s, String t) {
        return "";
    }
    public static void main(String[] args) {
        MinWindowString minWindowString = new MinWindowString();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        // BANC
        System.out.println(minWindowString.minWindow(s, t));
    }

}

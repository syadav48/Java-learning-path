package leetcode.string;

public class RepeatedPattern {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String cut = doubled.substring(1, doubled.length() - 1);
        System.out.println(cut);
        return cut.contains(s);
    }
    public static void main(String[] args) {
        String string = "aba";
        RepeatedPattern repeatedPattern = new RepeatedPattern();
        System.out.println(repeatedPattern.repeatedSubstringPattern(string));
    }
    //abcae abcae abcae
}

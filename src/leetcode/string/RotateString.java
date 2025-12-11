package leetcode.string;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        String doubled = s + s;
        String cuts = doubled.substring(1);
        System.out.println(cuts);
        return cuts.contains(goal);
    }
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "abcde";
        RotateString rotateString = new RotateString();
        System.out.println(rotateString.rotateString(s, goal));
    }

}

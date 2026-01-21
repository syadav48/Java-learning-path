package leetcode.string;

public class ReverseDegree {
    public int reverseDegree(String s){
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int revAlpha = (int) 123 - s.charAt(i);
            int index = i + 1;
            int multi = revAlpha * index;
            sum += multi;
        }
        return sum;

    };
    public static void main(String[] args) {
        String str = "zaza";
        ReverseDegree reverseDegree = new ReverseDegree();
        System.out.println(reverseDegree.reverseDegree(str));
    }
}

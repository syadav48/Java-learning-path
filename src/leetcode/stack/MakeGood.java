package leetcode.stack;

public class MakeGood {
    public String makeGood(String s) {
        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i < str.length() - 1; i++) {
            if(Math.abs(str.charAt(i) - str.charAt(i + 1)) == 32){
                str.delete(i, i+2);
                i = -1;
            }
        }
        return str.toString();
    }
    public String makeGoodUsingStack(String s) {
        StringBuilder str = new StringBuilder();
        for(char ch: s.toCharArray()){
            int length = str.length();
            if(length > 0 && Math.abs(str.charAt(length - 1) - ch) == 32){
                str.deleteCharAt(length - 1);
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        MakeGood makeGood = new MakeGood();
        System.out.println(makeGood.makeGoodUsingStack("leEeetcode"));
        System.out.println(makeGood.makeGoodUsingStack("abBAcC"));
        System.out.println(makeGood.makeGoodUsingStack("s"));
    }
}

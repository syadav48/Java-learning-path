package leetcode.stack;

public class RemoveDuplicates {
    public String removeDuplicates(String s) {
        StringBuilder str = new StringBuilder(s);
        for(int i = 0; i < str.length() - 1; i++){
            if(Math.abs(str.charAt(i) - str.charAt(i + 1)) == 0){
                str.delete(i, i + 2);
                i = -1;
            }
        }
        return str.toString();
    }
    public String removeDuplicatesUsingStack(String s) {
        StringBuilder str = new StringBuilder();
        for(char ch: s.toCharArray()){
            int len = str.length();
            if(len > 0 && str.charAt(len - 1) == ch){
                str.deleteCharAt(len - 1);
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicatesUsingStack("abbaca"));
        System.out.println(removeDuplicates.removeDuplicatesUsingStack("azxxzy"));
    }
}

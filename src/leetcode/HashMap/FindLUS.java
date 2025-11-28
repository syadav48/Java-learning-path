package leetcode.HashMap;

public class FindLUS {
    public int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        } else if (a.length() >= b.length()) {
            return a.length();
        } else {
            return b.length();
        }

    }
    public static void main(String[] args) {
        String a = "aefeaf";
        String b = "a";
        FindLUS findLUS = new FindLUS();
        System.out.println(findLUS.findLUSlength(a, b));
    }
}

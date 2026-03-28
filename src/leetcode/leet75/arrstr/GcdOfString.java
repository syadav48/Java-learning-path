package leetcode.leet75.arrstr;

public class GcdOfString {
    public String findRepeat(String str2){
        if(str2.length() % 2 != 0){
            return str2;
        }

        return "s";
    }
    public String gcdOfStrings(String str1, String str2) {
        String repeat = findRepeat(str2);
        return "S";
    }
    public static void main(String[] args) {
        String str1 = "ABABAB";
        String str2 = "ABAB";
        GcdOfString gcdOfString = new GcdOfString();
        System.out.println(gcdOfString.gcdOfStrings(str1, str2));
    }
}

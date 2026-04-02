package Interview;

import java.util.Arrays;
import java.util.List;

public class InterviewDelloite {
    public static String rearrange(String str){
        String[] split = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(String s: split){
            StringBuilder str1 = new StringBuilder();
            StringBuilder str2 = new StringBuilder();
            for(int i=0; i < s.length(); i++){
                if(i == 1){
                    str1.append(s.charAt(i));
                } else {
                    str2.append(s.charAt(i));
                }
                stringBuilder = str1.append(str2);
            }
        }
        return stringBuilder.toString();
    }
    public static String swapFirstTwo(String str){
        if(str.length() < 2) return str;
        char[] chars = str.toCharArray();
        char temp = chars[0];
        chars[0] = chars[1];
        chars[1] = temp;
        return new String(chars);
    }
    public static String rearrangeOpt(String str){
        String[] strings = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(String s: strings){
            stringBuilder.append(swapFirstTwo(s)).append(" ");
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        String str = "Hello World"; //"eHllo oWrld"
        System.out.println(InterviewDelloite.rearrangeOpt(str));
    }
}

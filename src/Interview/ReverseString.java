package Interview;

import java.util.Arrays;

public class ReverseString {
    public String reverseString(String string){
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = string.split(" ");
        String s = "Ram";
        s = "Ram Singh";
        //Runtime
        // Calling Garbage Collectors
        // token
        // spring starter ?? why ??
        // @Controller Advice
        // 401
        // Test Cases
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
            StringBuilder str = new StringBuilder();
            str.append(split[i]).reverse();
            stringBuilder.append(str);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
            ReverseString reverseString = new ReverseString();
            String s = "Hello Suryoday Yadav";
        //olleH yadoyruS vadaY
        System.out.println(reverseString.reverseString(s));
    }

}

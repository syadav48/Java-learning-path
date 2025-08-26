package leetcode.string;

import java.util.HashMap;

class UniChar{
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)){
                    continue;
                }
                return i;
            }

        }
        return -1;
    }
}

public class FirstUniChar {
    public static void main(String[] args){
        UniChar obj = new UniChar();
        int res = obj.firstUniqChar("loveleetcode");
        System.out.println(res);
    }
}

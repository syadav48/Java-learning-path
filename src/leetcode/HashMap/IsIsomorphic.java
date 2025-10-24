package leetcode.HashMap;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public static boolean isIsomorphic(String s, String t){
        Map<Character, Character> map = new HashMap<>();
        StringBuilder u = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i)) && !map.containsValue(t.charAt(i))){
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        for(int i = 0; i < s.length(); i++){
            Character temp = map.get(s.charAt(i));
            u.append(temp);
        }
        System.out.println(map);
        return u.toString().equals(t);
    };
    public static void main(String[] args) {
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("badc", "baba"));


    }
}

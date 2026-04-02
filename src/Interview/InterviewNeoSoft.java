package Interview;

import java.util.HashMap;
import java.util.Map;

public class InterviewNeoSoft {
    public Map<String, Integer> countByGroup(String str){
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String sub = str.substring(i, i + 2);
            // check the adjacent char
            if(str.charAt(i) == str.charAt(i + 1)){
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
        return map;
    }
    public int countChar(String str, String subset){
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            String sub = str.substring(i, i + 2);
            if(sub.equals(subset)){
                count++;
            }

        }
        return count;
    }
    public static void main(String[] args) {
        InterviewNeoSoft interviewNeoSoft = new InterviewNeoSoft();
        System.out.println(interviewNeoSoft.countChar("aabbaaccaahaa", "aa"));
        System.out.println(interviewNeoSoft.countByGroup("aabbaaccaahaa"));
        // aa bb aa cc aa haa
        // {aa: 4, bb:1, cc: 1 }
    }
}

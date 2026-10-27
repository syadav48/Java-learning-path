package helloInterview.dsa.problems.arrString;

import Interview.javaCore.interfaceExample.C;

import java.util.HashMap;
import java.util.Map;

public class StringComp {
    public int compress(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for (char ch: chars){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        System.out.println(map);
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                builder.append(entry.getKey());
            } else {
                builder.append(entry.getKey()).append(entry.getValue());
            }

        }
        System.out.println(builder.toString());
        return builder.toString().length();
    }

    public int compressInt(char[] chars){
        int write = 0;
        int i = 0;
        while (i < chars.length){
            char current = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == current){
                count++;
                i++;
            }
            chars[write++] = current;
            if(count > 1){
                char[] digits = String.valueOf(count).toCharArray();
                for(char digit: digits){
                    chars[write++] = digit;
                }
            }
        }
        return write;
    }
    public static void main(String[] args) {
        StringComp stringComp = new StringComp();
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(stringComp.compressInt(chars));
    }
}

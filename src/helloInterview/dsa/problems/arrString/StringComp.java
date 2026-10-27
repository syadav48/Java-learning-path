package helloInterview.dsa.problems.arrString;

import Interview.javaCore.interfaceExample.C;

import java.util.HashMap;
import java.util.Map;

public class StringComp {
    public int compress(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        int sum = 0;
        for (char ch: chars){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        System.out.println(map);
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            sum += entry.getValue();
        }
        return sum;
    }
    public static void main(String[] args) {
        StringComp stringComp = new StringComp();
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(stringComp.compress(chars));
    }
}

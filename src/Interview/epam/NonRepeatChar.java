package Interview.epam;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatChar {
    private static char nonRepeatChar(String string){
        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        for (char ch: string.toCharArray()){
            linkedHashMap.put(ch, linkedHashMap.getOrDefault(ch, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry: linkedHashMap.entrySet()){
            if(entry.getValue().equals(1)){
            return  entry.getKey();
        }}
        return '_';
    };
    public static void main(String[] args) {
        NonRepeatChar nonRepeatChar = new NonRepeatChar();
        String s = "awerttawry";
        System.out.println(NonRepeatChar.nonRepeatChar(s));
    }

}

package stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FIndingMaxVowel {
    public String findMaxVowel(List<String> words){
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        for (String str: words){
            HashMap<String, Integer> map = countVowel(str);
            System.out.println(map);
            for (Map.Entry<String, Integer> entry : map.entrySet()){
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }
            }


        }
        return maxKey;
    }
    public HashMap<String, Integer> countVowel(String str){
        HashMap<String, Integer> hashMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u'){
                count++;
            }
            hashMap.put(str, count);
        }
        return hashMap;
    }
    public static void main(String[] args) {
        List<String> words39 = Arrays.asList("stream", "java", "programming", "awesome");
        FIndingMaxVowel fIndingMaxVowel = new FIndingMaxVowel();
        System.out.println(fIndingMaxVowel.findMaxVowel(words39));
    }

}

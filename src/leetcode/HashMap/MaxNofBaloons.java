package leetcode.HashMap;

import java.util.HashMap;
import java.util.Map;

public class MaxNofBaloons {
    public int maxNoOfballoons(String text){
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        String balloon = "balloon";
        for (char ch: text.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < balloon.length(); i++) {
            if(map.get(balloon.charAt(i)) == null){
                return 0;
            }
            while (map.get(balloon.charAt(i)) != null && map.get(balloon.charAt(i)) > 0){
                map.put(balloon.charAt(i), map.get(balloon.charAt(i)) - 1);
                count++;
            }
        }
        return count / 7;
    }
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch: text.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> need = Map.of(
                'b', 1,
                'a', 1,
                'l', 2,
                'o', 2,
                'n', 1
        );
        int min = Integer.MAX_VALUE;
        for (char ch: need.keySet()){
            int available = map.getOrDefault(ch, 0);
            int required = need.get(ch);
            min = Math.min(min, available/required);
        }
       return  min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        MaxNofBaloons maxNofBaloons = new MaxNofBaloons();
        System.out.println(maxNofBaloons.maxNumberOfBalloons(text));
    }
}

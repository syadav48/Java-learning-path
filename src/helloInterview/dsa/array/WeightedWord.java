package helloInterview.dsa.array;

import java.util.HashMap;

public class WeightedWord {
    public Character modString(String str, HashMap<Character, Integer> map){
        int sum = 0;
        for(char ch: str.toCharArray()){
           sum +=  map.get(ch);
        }
        int mod = 26 - sum % 26;
        return (char) ('a' + mod - 1);
    }

    public String mapWordWeights(String[] words, int[] weights) {
        HashMap<Character, Integer> map = new HashMap<>();
        char ch = 'a';
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 26; i++){
            map.put(ch, weights[i]);
            ch++;
        }
        for(String str: words){
           Character s = modString(str, map);
           res.append(s);
        }
        System.out.println(map);
        return res.toString();
    }

    public static void main(String[] args) {
        String[] words1 = {"abcd","def","xyz"};
        String[] words2 = {"a","b","c"};
        String[] words3 = {"abcd"};
        int[] weights1 = {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        int[] weights2 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int[] weights3 = {7,5,3,4,3,5,4,9,4,2,2,7,10,2,5,10,6,1,2,2,4,1,3,4,4,5};
        WeightedWord weightedWord = new WeightedWord();
        System.out.println(weightedWord.mapWordWeights(words1, weights1));
        System.out.println(weightedWord.mapWordWeights(words2, weights2));
        System.out.println(weightedWord.mapWordWeights(words3, weights3));
    }
}

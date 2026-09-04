package helloInterview.dsa.hashTable;

import java.util.HashMap;
import java.util.Map;

public class DigitFreqStore {
    public int digitFrequencyScore(int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        String s = String.valueOf(n);
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            int digit = s.charAt(i) - '0';
            hashMap.put(digit, hashMap.getOrDefault(digit, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> map : hashMap.entrySet()){
            sum += map.getKey()*map.getValue();
        }
        return sum;
    }
    public int digitFrequencyScoreOpt(int n) {
        int sum = 0;
        while (n > 0){
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        DigitFreqStore digitFreqStore = new DigitFreqStore();
        System.out.println(digitFreqStore.digitFrequencyScore(122));
        System.out.println(digitFreqStore.digitFrequencyScore(101));
        System.out.println(digitFreqStore.digitFrequencyScoreOpt(101));
        System.out.println(digitFreqStore.digitFrequencyScoreOpt(122));
    }
}

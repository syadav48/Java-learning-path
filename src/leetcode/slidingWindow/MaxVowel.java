package leetcode.slidingWindow;

public class MaxVowel {
    public boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        int max = count;
        for(int i = k; i < s.length(); i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
            if(isVowel(s.charAt(i - k))){
                count--;
            }
            max = Math.max(max, count);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxVowel maxVowel = new MaxVowel();
        String s = "weallloveyou";
        int k = 7;
        System.out.println(maxVowel.maxVowels(s, k));
    }
}

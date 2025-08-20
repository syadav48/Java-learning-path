class Solution {
    public int countVowel(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                count++;
            }
        }
        return count;
    }
}

public class NoOfVowel {
    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.countVowel("ijsdjkksdfnjsndnjdfnjskdfnjksruuwucdjbbw"));
    }
}

package leetcode.recursion;

public class KthCharacter {
    public String appendCharacter(String str){
        StringBuilder sb = new StringBuilder();
        for(char ch: str.toCharArray()){
            sb.append((char) (ch + 1));
        }
        return sb.toString();
    }
    public char kthCharacter(int k) {
        if(k == 1) return 'a';
        StringBuilder word = new StringBuilder("a");
        String res = word.toString() + appendCharacter(word.toString());
        return res.length() >= k ? res.charAt(k) : kthCharacter(k);

    }
    public static void main(String[] args) {
        KthCharacter kthCharacter = new KthCharacter();
        System.out.println(kthCharacter.kthCharacter(5));
    }
}

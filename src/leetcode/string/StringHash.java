package leetcode.string;

public class StringHash {
    public String stringHash(String s, int k) {
        int n = s.length();
        StringBuilder str = new StringBuilder();
        int i1 = 0, i2 = 0;
        if(k == 1){
            return s;
        }
        if(n/k != 1){
            for (int i = 0; i < k; i++) {
                i1 += (int) s.charAt(i) - 97;
            }
            for (int i = k; i < n; i++) {
                i2 += (int) s.charAt(i) - 97;
            }
            int i3 = i1 % 26 + 97;
            int i4 = i2 % 26 + 97;
            str.append((char) i3);
            str.append((char) i4);
            return  str.toString();
        } else {
            for (int i = 0; i < k; i++) {
                i1 += (int) s.charAt(i) - 97;
            }
            int i3 = i1 % 26 + 97;
            str.append((char) i3);
            System.out.println(i3);
            return str.toString();
        }
    }

    public String advancedStringHash(String s, int k){
        int n = s.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i += k) {
            int sum = 0;
            for (int j = i; j <i + k; j++) {
                sum += s.charAt(j) - 'a';
            }
            char hashedChar = (char) ('a' + (sum % 26));
            result.append(hashedChar);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String s = "ant";
        int k = 1;
        StringHash stringHash = new StringHash();
        System.out.println(stringHash.stringHash(s, k));
    }
}

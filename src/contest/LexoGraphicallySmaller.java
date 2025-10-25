package contest;

public class LexoGraphicallySmaller {
    public static String lexSmallest(String s) {
        StringBuilder str = new StringBuilder();
        char minChar = s.charAt(0);
        int n = s.length();
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < minChar) {
                minChar = s.charAt(i);
            }
        }
        int k = s.indexOf(minChar) + 1;
        String firstReverse = new StringBuilder(s.substring(0, k)).reverse().toString() + s.substring(k);
        String lastRevers = s.substring(0, n - k) + new StringBuilder(s.substring(n - k)).reverse().toString();
        String result = firstReverse.compareTo(lastRevers) < 0 ? firstReverse : lastRevers;
        return  result;
    };
    public static void main(String[] args) {
        System.out.println(lexSmallest("dcab"));
        System.out.println(lexSmallest("abba"));
        System.out.println(lexSmallest("zxy"));
    }
}

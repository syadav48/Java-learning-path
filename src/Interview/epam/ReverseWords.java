package Interview.epam;

public class ReverseWords {
    public static String reverseWords(String s) {
        String[] strings = s.trim().split("\\s+");
        System.out.println(strings.toString());
        StringBuilder str = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            str.append(strings[i]).append(" ");
        }
        return str.toString().trim();
    };
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(ReverseWords.reverseWords(s));
    }
}

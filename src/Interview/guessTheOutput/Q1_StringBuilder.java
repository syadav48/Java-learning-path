package Interview.guessTheOutput;

public class Q1_StringBuilder {
    public static void main(String[] args) {
        StringBuilder str1 = new StringBuilder("abc");
        StringBuilder str2 = new StringBuilder("abc");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }
}

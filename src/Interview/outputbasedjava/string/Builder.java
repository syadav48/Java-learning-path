package Interview.outputbasedjava.string;

public class Builder {
    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = "abc";
        String str3 = str1.intern();
        System.out.println(str3 == str2);
        System.out.println(str3 == str1);
        StringBuilder stringBuilder1 = new StringBuilder("abc");
        StringBuilder stringBuilder2 = new StringBuilder("abc");
        System.out.println(stringBuilder1.equals(stringBuilder2));
    }
}

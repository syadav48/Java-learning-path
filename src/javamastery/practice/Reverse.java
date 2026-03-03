package javamastery.practice;

public class Reverse {
    public String reverseString(String str){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    };
    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        String str = "reverse";
        System.out.println(reverse.reverseString(str));
    }
}

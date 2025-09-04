package string;

public class OnlyDigit {
    public static void main(String[] args) {
        String str1 = "12345";
        String str2 = "123a5";
        for (int i = 0; i < str2.length(); i++) {
            if(Character.isLetter(str1.charAt(i))){
                System.out.println(true);
            }
        }
    }
}

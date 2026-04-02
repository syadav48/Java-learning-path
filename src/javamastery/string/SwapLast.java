package javamastery.string;

public class SwapLast {
    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public String swapVowel(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            // move left until vowel
            while (left < right && !isVowel(arr[left])) {
                left++;
            }

            // move right until vowel
            while (left < right && !isVowel(arr[right])) {
                right--;
            }

            // swap vowels
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return new String(arr);
    }
    public String swap(String s){
        char[] charArray = s.toCharArray();
        char temp = s.charAt(0);
        charArray[0] = charArray[s.length() - 1];
        charArray[s.length() - 1] = temp;
        return new String(charArray);

    }
    public String swaplast(String str){
        String[] strings = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(String s: strings){
            stringBuilder.append(swap(s)).append(" ");
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        SwapLast swapLast = new SwapLast();
        System.out.println(swapLast.swapVowel("hello world"));
        System.out.println(swapLast.swapVowel("hello world"));
    }
}

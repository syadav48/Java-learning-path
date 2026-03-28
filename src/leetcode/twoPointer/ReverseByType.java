package leetcode.twoPointer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseByType {
    public String reverseByType(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (right > left){
            if(!Character.isLowerCase(arr[left])){
                left++;
            } else if (!Character.isLowerCase(arr[right])) {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
        return new String(arr);
    };
    public static void main(String[] args) {
        String str = ")ebc#da@f("; //"(fad@cb#e)"
        ReverseByType reverseByType = new ReverseByType();
        System.out.println(reverseByType.reverseByType(str));
    }
}

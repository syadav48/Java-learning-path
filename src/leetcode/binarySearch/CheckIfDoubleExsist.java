package leetcode.binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckIfDoubleExsist {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int left = i;
            int right = arr.length - 1;
            int target = arr[i] * 2;
            while (right >= left){
                int mid = left + (right - left)/2;
                if (mid == i) {
                    if (mid < arr.length - 1) mid++;
                    else break;
                }
                if(arr[mid] == target){
                    return true;
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        return false;
    }
    public boolean checkIfExsist(int[] arr){
        Set<Integer> set = new HashSet<>();
        for(int num: arr){
            if(set.contains(2 * num) || (num % 2 == 0 && set.contains(num / 2))){
                return true;
            }
            set.add(num);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {10,2,5,3};
        CheckIfDoubleExsist checkIfDoubleExsist = new CheckIfDoubleExsist();
        System.out.println(checkIfDoubleExsist.checkIfExist(arr));
    }
}

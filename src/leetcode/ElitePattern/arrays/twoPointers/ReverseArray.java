package leetcode.ElitePattern.arrays.twoPointers;

public class ReverseArray {
    public void reverseArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (end > start){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 6, 5};
        ReverseArray reverseArray = new ReverseArray();
        reverseArray.reverseArray(nums);
    }
}

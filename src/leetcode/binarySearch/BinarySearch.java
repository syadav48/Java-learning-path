package leetcode.binarySearch;

public class BinarySearch {
    public  static int binarySearch(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == target){
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static int binarySearchRecursive(int[] arr, int low, int high, int target) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            return binarySearchRecursive(arr, mid + 1, high, target);
        else
            return binarySearchRecursive(arr, low, mid - 1, target);
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int result = binarySearch(arr, 30);
        System.out.println(result);
        System.out.println(binarySearchRecursive(arr, 0, arr.length - 1, 30));
    }
}

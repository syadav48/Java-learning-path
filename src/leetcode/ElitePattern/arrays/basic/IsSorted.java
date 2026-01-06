package leetcode.ElitePattern.arrays.basic;

public class IsSorted {
    public boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 5, 7, 7, 7, 8, 12, 13, 15, 15, 15, 19};
        IsSorted isSorted = new IsSorted();
        System.out.println(isSorted.isSorted(arr));
    }
}

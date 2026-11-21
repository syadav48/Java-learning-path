package helloInterview.dsa.problems.slidingWindow;

public class NumOfSubArr {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            if(right >= k){
                sum -= arr[right - k];
            }
            if(right >= k - 1 && sum >= threshold * k){
                count++;
            }

        }
        return count;
    }
    public static void main(String[] args) {
        NumOfSubArr numOfSubArr = new NumOfSubArr();
        int[] arr = new int[]{2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;
        int[] arr1 = new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        int k1 = 3;
        int threshold1 = 5;
        System.out.println(numOfSubArr.numOfSubarrays(arr, k, threshold));
        System.out.println(numOfSubArr.numOfSubarrays(arr1, k1, threshold1));
    }
}

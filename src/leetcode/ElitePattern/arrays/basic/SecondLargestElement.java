package leetcode.ElitePattern.arrays.basic;

public class SecondLargestElement {
    public int getSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int num: arr){
            if(num > largest){
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
      return secondLargest;
    };
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        SecondLargestElement secondLargestElement = new SecondLargestElement();
        System.out.println(secondLargestElement.getSecondLargest(arr));
    }
}

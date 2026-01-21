package stream.InterviewPractice;

import java.util.List;

public class Q2_SecondHighest {
    public static void main(String[] args) {
        List<Integer> list = List.of(10, 20, 30, 40);
       int largest = Integer.MIN_VALUE;
       int secondLargest = Integer.MIN_VALUE;
       for(int num: list){
           if(num > largest){
               secondLargest = largest;
               largest = num;
           } else if (secondLargest < num && num != largest) {
               secondLargest = num;
           }
       }
        System.out.println(secondLargest);

    }
}

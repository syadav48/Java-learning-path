package Interview;

import stream.qns.DataFactory;
import stream.qns.Transaction;

import java.util.*;
import java.util.stream.Collectors;


public final class InterviewQns {
    public static void mapfruits(String[] arr){
        Map<Integer, List<String>> collect = Arrays.stream(arr).collect(Collectors.groupingBy(
                x -> x.length(),
                Collectors.toList()
        ));
        System.out.println(collect);

    }
    public static void groupNo(int[] arr){
       List<List<Integer>> res = new ArrayList<>();
       //arr[i], 18 - arr[i]
        for (int i = 0; i < arr.length ; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                if(arr[i] + arr[j] == 18){
                    list.add(arr[i]);
                    list.add(arr[j]);
                }
            }
            if(list.size() > 1){
                res.add(list);
            }
        }
        System.out.println(res);

    }
    public static void main(String[] args) {
        String[] arr = {"apple","banana","pear","kiwi"};
        int [] arr1 = {1,2,3,4,5,6,7,8,9,10,11,17}; //1,17, 7,11, 8,10
        InterviewQns.mapfruits(arr);
        InterviewQns.groupNo(arr1);
    }
}

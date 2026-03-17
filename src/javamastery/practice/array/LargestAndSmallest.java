package javamastery.practice.array;

import java.util.*;
import java.util.stream.Collectors;

public class LargestAndSmallest {
    public static int[] findLargestSmallest(int[] arr){
        int max = Arrays.stream(arr).boxed().max(Comparator.comparing(x -> x)).orElseThrow();
        int min = Arrays.stream(arr).boxed().min(Comparator.comparing(x -> x)).orElseThrow();
        return new int[] {max, min};
    }
    public static int[] removeDuplicates(int[] arr){
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num: arr){
            hashSet.add(num);
        }
        return hashSet.stream().mapToInt(Integer::intValue).toArray();
    }
    public static int[] findDuplicates(int[] arr){
        List<Integer> list = new ArrayList<>();
        Map<Integer, Long> collect = Arrays.stream(arr).boxed().collect(
                Collectors.groupingBy(
                        x -> x,
                        Collectors.counting()
                )
        );
        for (Map.Entry<Integer, Long> entry: collect.entrySet()){
            if(entry.getValue() > 1){
                list.add(entry.getKey());
            }
        }
        return list.stream().mapToInt(x -> x).toArray();

    }
    public static int[] findDuplicatesOptimum(int[] arr){
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();
        for(int num: arr){
            if(seen.add(num)){
                duplicates.add(num);
            }
        }
        return duplicates.stream().mapToInt(x -> x).toArray();
    }
    public static int secondLargest(int[] arr){
        int max = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int num: arr){
            if(num > max){
                secondLargest = max;
                max = num;
            } else if (num > secondLargest && num != max) {
                secondLargest = num;
            }
        }
        System.out.println(max + " " +  secondLargest);
        return secondLargest;
    }
    public static List<List<Integer>> findAllPair(int[] arr, int sum){
       List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list1 = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if(i != j && sum - arr[i] == arr[j]){
                   list1.add(arr[i]);
                   list1.add(arr[j]);
                }
            }
            if(list1.size() == 2){
                list.add(list1);
            }
        }
        return list;

    }

    public static List<List<Integer>> findAllPairOptimum(int[] arr, int sum){
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int num: arr){
            int complement = sum - num;
            if(set.contains(complement)){
                list.add(Arrays.asList(complement, num));
            }
            set.add(num);
        }
        return list;
    }
    public static int[] moveAllZeros(int[] arr){
        List<Integer> list = new ArrayList<>();
        int[] ints = new int[arr.length];
        int i = 0;
        for(int num: arr){
            if(num != 0){
                list.add(num);
            }
        }
        while (i < arr.length){
            if(i < list.size()){
                ints[i] = list.get(i);
            } else {
                ints[i] = 0;
            }
            i++;
        }
        return ints;
    }
    public static int[] moveAllZerosOptimum(int[] arr){
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                arr[index] = arr[i];
                index++;
            }
        }
        while (index < arr.length){
            arr[index] = 0;
            index++;
        }
        return arr;
    }
    public static int[] merge(int[] arr1, int[] arr2){
        List<Integer> list = new ArrayList<>();
       Arrays.sort(arr1);
       Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            list.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            list.add(arr2[i]);
        }
        return list.stream().sorted().mapToInt(x -> x).toArray();
    }
    public static int[] mergeOpt(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int[] merge = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m){
            if(arr1[i] <= arr2[j]){
                merge[k++] = arr1[i++];
            } else {
                merge[k++] = arr2[j++];
            }
        }
        while (i < n){
            merge[k++] = arr1[i++];
        }
        while (j < m){
            merge[k++] = arr2[j++];
        }
        return merge;
    }
    public static int[] commonElement(int[] arr1, int[] arr2){
        List<Integer> list = Arrays.stream(arr2).boxed().toList();
        return Arrays.stream(arr1).boxed().filter(x -> list.contains(x)).distinct().mapToInt(x -> x).toArray();
    };
    public static int[] rotateElement(int[] arr1, int k){
        int[] res = new int[arr1.length];
        for (int i = k; i < arr1.length; i++) {
            res[i - k] = arr1[i];
        }
        for(int i = 0; i < k; i++){
            res[arr1.length - k + i] = arr1[i];
        }
        return res;
    };
    public static int[] rotateElementOpt(int[] arr1, int k){
        int n = arr1.length;
        k = k % n;
        reverse(arr1, 0, n - 1);
        reverse(arr1, k, n - 1);
        reverse(arr1, 0, n - 1);
        return arr1;
    };
    public static void reverse(int[] arr, int start, int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,2,3,5,1,4,5,6,9,3}; // 5
        int[] res = {5,0,2,3,4,2,1,0,0,10,0,1};
//        System.out.println(Arrays.toString(LargestAndSmallest.findLargestSmallest(arr)));
//        System.out.println(Arrays.toString(LargestAndSmallest.removeDuplicates(arr)));
//        System.out.println(Arrays.toString(LargestAndSmallest.findDuplicates(arr)));
//        System.out.println(Arrays.toString(LargestAndSmallest.findDuplicatesOptimum(arr)));
//        System.out.println(LargestAndSmallest.secondLargest(arr));
//        System.out.println(LargestAndSmallest.findAllPair(arr, 5));
//        System.out.println(LargestAndSmallest.findAllPairOptimum(arr, 5));
//        System.out.println(Arrays.toString(LargestAndSmallest.moveAllZeros(res)));
//        System.out.println(Arrays.toString(LargestAndSmallest.moveAllZerosOptimum(res)));
//        System.out.println(Arrays.toString(LargestAndSmallest.merge(res, arr)));
//        System.out.println(Arrays.toString(LargestAndSmallest.mergeOpt(res, arr)));
        System.out.println(Arrays.toString(LargestAndSmallest.rotateElement(res, 4)));
        System.out.println(Arrays.toString(LargestAndSmallest.rotateElementOpt(res, 4)));
    }
}

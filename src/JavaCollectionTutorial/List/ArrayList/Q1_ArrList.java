package JavaCollectionTutorial.List.ArrayList;

import stream.collectors.DataFactory;
import stream.collectors.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Q1_ArrList {
    public static void removeDuplicates(List<Integer> list){
        List<Integer> res1 = new LinkedHashSet<>(list).stream().toList();
        List<Integer> res2 = list.stream().distinct().toList();
        List<Integer> res3 = new ArrayList<>();
        for(int num: list){
            if(!res3.contains(num)){
                res3.add(num);
            }
        }
//        System.out.println(res1);
//        System.out.println(res2);
//        System.out.println(res3);
    }
    public static void secondHighestElement(List<Integer> list){
        list.sort((x, y) -> y -x);
        //System.out.println(list.get(1));
    }
    public static void rotateElement(List<Integer> list, int k){
      int n = list.size();
      k = k % n;
      List<Integer> rotated = new ArrayList<>();
      rotated.addAll(list.subList(n - k, n));
      rotated.addAll(list.subList(0, n - k));
        System.out.println(rotated);
    }
    public static void commonElement(List<Integer> list1, List<Integer> list2){
        HashSet<Integer> set1 = new HashSet<>(list1);
        HashSet<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        List<Integer> res = set1.stream().toList();
        List<Integer> list = list1.stream().filter(list1::contains).distinct().toList();
        //System.out.println(list);
        //System.out.println(res);
    }
    public static void removeLowerThanX(List<Integer> list1){
       //list1.stream().filter(x -> x > 3);
        list1.removeIf(x -> x < 6);
        System.out.println(list1);
    }
     public  static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 1, 3, 3, 9, 7, 5, 9, 2);
        List<Integer> number = Arrays.asList(5, 1, 3, 3, 9, 7, 5, 9, 2, 5, 4, 7);
        List<Integer> number1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> number2 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> number3 = Arrays.asList(4, 5, 6, 7, 8);
        List<Integer> number4 = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8));
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Aaron", "Bella", "Anna", "Alex");
        List<Employee> employees = DataFactory.getEmployees();
        removeDuplicates(numbers);
        secondHighestElement(number);
        rotateElement(number1, 2);
        commonElement(number2, number3);
        removeLowerThanX(number4);

    }
}

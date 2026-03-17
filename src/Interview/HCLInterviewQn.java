package Interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class HCLInterviewQn {
    public static List<Integer> fondIntersection(List<Integer> list1, List<Integer> list2){
      List<Integer> result = new ArrayList<>();
      for (Integer num: list1){
          if(list2.contains(num)){
              result.add(num);
          }
      }
        List<Integer> list = list1.stream().filter(list2::contains).toList();
        System.out.println(list);

        return result;

    }
    public static List<Integer> findDuplicates(List<Integer> list1){
        HashSet<Integer> hashSet = new HashSet<>();
        for(int num: list1){
            hashSet.add(num);
        }
        String s1="Hello";
        String s2=new String("Hello"); // 1

        return hashSet.stream().toList();
    }
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1,2,2,4,5,6,6,7);
        List<Integer> list2 = List.of(3,4,5,6,7,8);
        System.out.println(HCLInterviewQn.fondIntersection(list1, list2));
        System.out.println(HCLInterviewQn.findDuplicates(list1));

    }

}

package JavaCollectionTutorial.Set.HashSet;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q1_Hashset {
    public static void sampleSetQns(List<Integer> list){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> sets = new HashSet<>(list);
        //System.out.println(sets);
        for(Integer num: list){
            set.add(num);
        }
        set.addAll(list);
        //System.out.println(set);
        List<Integer> latestList = new HashSet<>(list).stream().toList();
        //System.out.println(latestList);
        List<Integer> newList =  set.stream().toList();
        //System.out.println(newList);
    }
    public static void containsAnother(HashSet<Integer> set1, HashSet<Integer> set2){
        boolean containing = set1.containsAll(set2);
        //System.out.println(containing);
    }
    public static void unionAll(HashSet<Integer> set1, HashSet<Integer> set2){
        Set<Integer> union = Stream.concat(set1.stream(), set2.stream()).collect(Collectors.toSet());
        //System.out.println(union);
        set1.addAll(set2);
        //System.out.println(set1);
    }
    public static void intersection(HashSet<Integer> set1, HashSet<Integer> set2){
         set1.retainAll(set2);
        //System.out.println(set1);
    }
    public static void differences(HashSet<Integer> set1, HashSet<Integer> set2){
        set1.removeAll(set2);
        //System.out.println(set1);
    }
    public static void upperCase(HashSet<String> set){
        Set<String> res = set.stream().map(String::toUpperCase).collect(Collectors.toSet());
        //System.out.println(res);
    }
    public static void removeIfAll(HashSet<String> set){
        Set<String> res = set.stream().filter(x -> x.length() > 5).collect(Collectors.toSet());
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            if(it.next().length() <= 5){
                it.remove();
            }
        }
        res.removeIf(x -> x.contains("o"));
        //System.out.println(set);
        //System.out.println(res);
    }
    public static void isSetEqual(HashSet<Integer> set1, HashSet<Integer> set2){
       boolean isEq = set1.equals(set2);
       boolean isEqu = set1.containsAll(set2);
        //System.out.println(isEq);
        //System.out.println(isEqu);
    }
    public static void iterateAll(HashSet<Integer> set){
        Set<Integer> set1 = set.stream().filter(x -> x % 2 != 0).collect(Collectors.toSet());
        //System.out.println(set1);
        //set.forEach(System.out::println);
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            if(it.next() % 2 == 0){
                it.remove();
            }
        }
        System.out.println(set);
    }
    public static void maxElem(HashSet<Integer> set){
       Optional<Integer> max = set.stream().max((x, y) -> x - y);
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,2,3,4,4,5);
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3, 2));
        HashSet<Integer> set3 = new HashSet<>(Arrays.asList(3, 4, 5, 6, 8, 9));
        HashSet<Integer> set4 = new HashSet<>(Arrays.asList(1, 4, 7));
        HashSet<Integer> set5 = new HashSet<>(Arrays.asList(3, 5, 4));
        HashSet<Integer> set6 = new HashSet<>(Arrays.asList(3, 5, 4, 6, 7, 9, 1));
        HashSet<String> set7 = new HashSet<>(Arrays.asList("apple","banana","orange"));
        HashSet<String> set8 = new HashSet<>(Arrays.asList("apple","banana","orange"));
        HashSet<Integer> set9 = new HashSet<>(Arrays.asList(3, 5, 4));
        HashSet<Integer> set10 = new HashSet<>(Arrays.asList(3, 5, 4, 6));
        sampleSetQns(list);
        containsAnother(set1, set2);
        unionAll(set1, set3);
        intersection(set3, set2);
        differences(set4, set5);
        iterateAll(set6);
        upperCase(set7);
        removeIfAll(set8);
        isSetEqual(set9, set10);
        maxElem(set10);



    }
}

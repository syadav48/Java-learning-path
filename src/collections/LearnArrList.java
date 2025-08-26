package collections;

import java.util.*;

public class LearnArrList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> arrList = new ArrayList<>();
        List<Integer> newList = Arrays.asList(1, 2, 3, 4, 5);
        arrList.add(15);
        arrList.add(23);
        arrList.add(15);
        arrList.add(23);

        list.add(9);
        list.add(8);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(19);
        list.add(4, 3);
        list.addAll(arrList);
        Iterator<Integer> it = list.iterator();
//        for (int i: list){
//            System.out.println("iterator- forEach" + " " + i);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("iterator- for" + " " + list.get(i));
//        }
        while (it.hasNext()){
            System.out.println("iterator" + " " + it.next());
        }
        arrList.addFirst(0);
        arrList.addLast(6);
        System.out.println(newList);
        System.out.println(arrList);
        System.out.println(arrList.getFirst());
        System.out.println(arrList.getLast());


        System.out.println(arrList.lastIndexOf(23));
        list.set(8, 4);
        list.sort(Comparator.naturalOrder());
        System.out.println("Ascending: " + list);
        System.out.println();
        System.out.println();
        System.out.println(list.isEmpty());
        System.out.println(list.hashCode());
        System.out.println(list.containsAll(arrList));
        System.out.println(list.contains(97));
        System.out.println(list.get(5));
        System.out.println(list.size());
        System.out.println(list);
    }
}

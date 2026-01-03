package javamastery.Iterator;

import java.util.*;

public class IteratorClass {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Set<Integer> set = new HashSet<>();
        set.add(4);
        set.add(5);
        set.add(6);
       Iterator<Integer> iterator = list.iterator();
        ListIterator<Integer> listIterator = list.listIterator();
        Iterator<Integer> setIterator = set.iterator();
       while (iterator.hasNext()){
           System.out.println(iterator.next());
       }
       while (listIterator.hasNext()){
           System.out.println("Forward:"+  listIterator.next());
       }
       while (listIterator.hasPrevious()){
           System.out.println("Backward:"+ listIterator.previous());
       }
        while (setIterator.hasNext()){
            System.out.println("setnext:"+ setIterator.next());
        }

    }
}

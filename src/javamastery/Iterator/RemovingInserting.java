package javamastery.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class RemovingInserting {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext() && list.size() < 10){
            list.add(5);
        }
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()){
            System.out.println("prev:"+ listIterator.previous());
        }
        System.out.println(list);
    }
}

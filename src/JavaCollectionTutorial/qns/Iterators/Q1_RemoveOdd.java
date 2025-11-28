package JavaCollectionTutorial.qns.Iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Q1_RemoveOdd {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6,7,8));
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next() % 2 != 0){
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}

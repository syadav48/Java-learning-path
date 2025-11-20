package JavaCollectionTutorial.qns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q7_RemoveAllEven {
    public static void main(String[] args) {
        //1 - good way and optimum
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6,7,8));
        list.removeIf(x -> x % 2 == 0);
        System.out.println(list);

        //2
        List<Integer> list1 = new ArrayList<>(List.of(1,2,3,4,5,6,7,8));
        Iterator<Integer> it = list1.iterator();
        while (it.hasNext()){
            Integer val = it.next();
            if(val % 2 == 0){
                it.remove();
            }
        }
        System.out.println(list1);

    }
}

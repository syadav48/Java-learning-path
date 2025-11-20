package JavaCollectionTutorial.qns.List;

import java.util.ArrayList;
import java.util.List;

public class Q3_ShiftingZero {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            integerList.add(i);
        }
        integerList.add(3, 0);
        integerList.add(2, 0);
        integerList.add(5, -1);
        System.out.println(integerList);
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < integerList.size(); i++) {
            if(integerList.get(i) != 0){
                list.add(integerList.get(i));
            } else {
                list1.add(integerList.get(i));
            }
        }
        list.addAll(list1);
        System.out.println(list);


        // optimize one

        int insertPos = 0;
        for (Integer num: integerList){
            if(num != 0){
                integerList.set(insertPos++, num);
            }
        }
        while (integerList.size() > insertPos){
            integerList.set(insertPos++, 0);
        }

        System.out.println(integerList);


    }
}

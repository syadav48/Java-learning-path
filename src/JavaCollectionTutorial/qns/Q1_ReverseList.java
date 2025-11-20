package JavaCollectionTutorial.qns;

import java.util.*;
import java.util.stream.IntStream;


public class Q1_ReverseList {
    public static void main(String[] args) {
        //1
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        List<Integer> list1 = list.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(list1);
        Collections.reverse(list);
        System.out.println(list);

        // without using stream and reverse methods:
        for(int i = 0, j = list.size() - 1; i < j; i++, j--){
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
        System.out.println(list);
    }

    public static class Q6_ListToSublist {
        public static void main(String[] args) {
            //1
            List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();
            for(Integer num : list){
                list1.add(num);
                if(list1.size() == 3){
                    result.add(new ArrayList<>(list1));
                    list1.clear();
                }
            }
            System.out.println(result);

            //2
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                res.add(list.subList(i, Math.min(i + 3, list.size())));
            }
            System.out.println(res);

            //3
            int size = 3;

            List<List<Integer>> collect = IntStream.range(0, (list.size() + size - 1) / size)
                    .mapToObj(i -> list.subList(i * size,
                            Math.min((i + 1) * size, list.size())))
                    .toList();

            System.out.println(collect);

        }
    }
}

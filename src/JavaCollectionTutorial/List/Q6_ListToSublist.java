package JavaCollectionTutorial.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q6_ListToSublist {
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

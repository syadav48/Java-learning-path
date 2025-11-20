package JavaCollectionTutorial.qns;

import java.util.*;

public class Q5_SecondHighestNo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,7,7,7));
        Integer secondHighest = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElseThrow();
        System.out.println(secondHighest);

        // above one is good to go, here are more:

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(list.stream().distinct().toList());
        pq.poll();
        int second = pq.poll();
        System.out.println(second);

    }
}

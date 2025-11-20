package JavaCollectionTutorial.qns;

import stream.qns.DataFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class Q11_ListtoInt {
    public static void main(String[] args) {
        int[] arr = DataFactory.numbers().stream().mapToInt(x -> x).toArray();
        System.out.println(Arrays.toString(arr));
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        System.out.println(list);
    }
}

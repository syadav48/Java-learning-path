package JavaCollectionTutorial.qns.Map;

import stream.qns.DataFactory;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Q1_CountWordFrequncy {
    public static void main(String[] args) {
        //1
        Map<String, Long> collect = Arrays.stream(DataFactory.paragraph().split(" ")).collect(Collectors.groupingBy(
                x -> x,
                Collectors.counting()
        ));
        System.out.println(collect);
        //2


    }
}

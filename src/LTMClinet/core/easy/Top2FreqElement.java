package LTMClinet.core.easy;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Top2FreqElement {
    public String[] findTwoElem(String[] strings){
        List<String> list = new ArrayList<>();
        Map<String, Long> collect = Arrays.stream(strings).collect(Collectors.groupingBy(
                x -> x,
                Collectors.counting()
        ));
        System.out.println(collect);
        List<Map.Entry<String, Long>> list1 = collect.entrySet().stream().toList();
        list1.stream().sorted().sorted();
        return strings;
    }
    public static void main(String[] args) {
        String [] strings = {"i","love","i","orange","apple","love","coding" };
        // i, love
        Top2FreqElement top2FreqElement = new Top2FreqElement();
        top2FreqElement.findTwoElem(strings);

    }
}

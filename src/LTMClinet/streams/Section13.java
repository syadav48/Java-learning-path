package LTMClinet.streams;


import stream.qns.DataFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Section13 {
    public static void main(String[] args) {
        Map<String, List<String>> collect = DataFactory.employees().stream()
                .collect(
                        Collectors.groupingBy(
                                x -> x.getCity(),
                                Collectors.mapping(x -> x.getName(), Collectors.toList())
                        )
                );
        System.out.println(collect);
    }
}

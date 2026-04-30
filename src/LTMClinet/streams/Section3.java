package LTMClinet.streams;

import company.mockdata.DataFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Section3 {

    public static void main(String[] args) {
        List<String> list = DataFactory.getEmployees().stream().map(x -> x.getName().toUpperCase()).toList();
        System.out.println(list);
        List<String> list1 = stream.qns.DataFactory.sentences().stream().map(x -> x.split(" "))
                .flatMap(Arrays::stream).toList();
        System.out.println(list1);
        String collect = stream.qns.DataFactory.employees().stream().map(x -> x.getSkills()).distinct()
                .flatMap(x -> x.stream()).collect(Collectors.joining(" "));
        System.out.println(collect);
    }
}

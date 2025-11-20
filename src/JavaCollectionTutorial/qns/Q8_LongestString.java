package JavaCollectionTutorial.qns;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Q8_LongestString {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Array", "ofSize", "Length", "Different", "Size"));
        String longestString =  list.stream().sorted(Comparator.comparing(x -> x.length(), Comparator.reverseOrder())).findFirst().orElseThrow();
        System.out.println(longestString);
    }
}

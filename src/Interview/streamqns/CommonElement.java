package Interview.streamqns;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CommonElement {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,2,3,5,3,3,null, null, 4);
        List<Integer> list2 = Arrays.asList(1,2,2,5,5,6,7,9,4);
        list1.stream().filter(list2::contains).forEach(System.out::println);
    }
}

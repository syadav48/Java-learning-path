package JavaCollectionTutorial.qns.Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q7_NoOfUniqueWords {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Mango", "Apple", "Orange", "Apple", "Coconut", "Mango", "Mango"));
        Set<String> set = new HashSet<>(list);
        System.out.println(set.size());
    }

}

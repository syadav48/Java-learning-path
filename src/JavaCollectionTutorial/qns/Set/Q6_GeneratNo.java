package JavaCollectionTutorial.qns.Set;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

public class Q6_GeneratNo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        Random random = new Random();
        while (set.size() < 20){
            int num = random.nextInt(100, 1000);
            set.add(num);
        }
        System.out.println(set);
    }
}

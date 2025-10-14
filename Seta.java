import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//import java.util.TreeSet;

public class Seta {
    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<Integer>();
        // JavaCollectionTutorial.Set<Integer> nums = new TreeSet<Integer>(); // useful for sorted list
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(8);
        nums.add(8);
        System.out.println(nums);

        Iterator<Integer> values = nums.iterator();
        while (values.hasNext()) {
            System.out.println(values.next());

        }

    }
}

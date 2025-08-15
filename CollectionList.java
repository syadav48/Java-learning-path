import java.util.ArrayList;
//import java.util.Collection;
import java.util.List;

public class CollectionList {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>();//using collection you cant tract the index, best for addition, push or pop
        //hecne List is useful for index tracking
        nums.add(5);
        nums.add(6);
        nums.add(8);
        nums.add(7);
        nums.set(2, 4);
        System.out.println(nums.get(3));

        System.out.println(nums);
        for(Integer n: nums)
        {
            System.out.println(n);
        }
    }
}

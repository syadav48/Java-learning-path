package helloInterview.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class MinPairRemoval {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num: nums){
            list.add(num);
        }
        int options = 0;
        while (isListNonDecreasing(list)){
            int minSum = Integer.MAX_VALUE;
            int minIndex = 0;

            // find minimum adjacent pair
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                System.out.println(sum);
                if(sum < minSum){
                    minSum = sum;
                    minIndex = i;
                }
            }
            // merge the pair:
            list.set(minIndex, minSum);
            list.remove(minIndex + 1);
            System.out.println(list);
            options++;
        }

        return options;

    }

    private boolean isListNonDecreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i - 1) > list.get(i)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MinPairRemoval minPairRemoval = new MinPairRemoval();
        int[] nums = {5,2,3,1};
        System.out.println(minPairRemoval.minimumPairRemoval(nums));
    }
}

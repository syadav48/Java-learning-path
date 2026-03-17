package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class StableMountain {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < height.length; i++) {
            if(height[i - 1] > threshold){
                res.add(i);
            }
        }
        return res;
    };
    public static void main(String[] args) {
        StableMountain sm = new StableMountain();
        int[] height = {1,2,3,4,5};
        System.out.println(sm.stableMountains(height, 2));
    }
}

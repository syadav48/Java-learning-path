package leetcode.ElitePattern.arrays.twoPointers;

public class MostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int area = (end - start) * Math.min(height[start], height[end]);
        while (end > start){
            int width = end - start;
            int length = Math.min(height[start], height[end]);
            area = Math.max(area, width*length);
            if(height[start] > height[end]){
                end--;
            } else {
                start++;
            }
        }
        return area;
    }
    public static void main(String[] args) {
        MostWater mostWater = new MostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        //base:
        // height:
        // area:
        System.out.println(mostWater.maxArea(height));
    }
}

package helloInterview.dsa.twoPointer;

public class MostWater {
    public int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        while (right > left){
            int localArea = (right - left) * Math.min(height[left], height[right]);
            System.out.println(localArea + "localArea");
            area = Math.max(area, localArea);
            if(height[right] > height[left]){
                left++;
            } else {
                right--;
            }
        }

        return area;
    }
    public static void main(String[] args) {
        MostWater mostWater = new MostWater();
        int[] height = {1,1};
        System.out.println(mostWater.maxArea(height));
    }
}

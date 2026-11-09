package helloInterview.dsa.problems.twoPointer;

public class TrapWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        while (left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            }  else {
                if(height[right] >= rightMax){
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
    public static void main(String[] args) {
        TrapWater water = new TrapWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        // 1 + 1 + 1 + 1 + 2 +
        System.out.println(water.trap(height));
    }
}

package helloInterview.dsa.twoPointer;

public class TrappingWater {
    public int trappingWater(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int count = 0;
        while (right > left){
            if(rightMax > leftMax){
                left++;
                if(height[left] >= leftMax){
                    leftMax = height[left];
                } else {
                    count += leftMax - height[left];
                }
            } else {
                right--;
                if(height[right] >= rightMax){
                    rightMax = height[right];
                } else {
                    count += rightMax - height[right];
                }
            }
        }
    return count;
    }
    public static void main(String[] args) {
        TrappingWater water = new TrappingWater();
        int[] height = {3, 4, 1, 2, 2, 5, 1, 0, 2};
        System.out.println(water.trappingWater(height));
    }
}

package helloInterview.dsa.problems.twoPointer;

public class MostWater {
    public int maxArea(int[] height) {
        int maxWidth = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (right > left){
            if(height[right] > height[left]){
                maxWidth = Math.max(maxWidth, right - left);
                maxHeight = Math.max(maxHeight, Math.abs(height[right] - height[left]));
                maxArea =Math.max(maxArea, maxWidth*maxHeight);
                left++;
            }
            right--;
        }
        return maxArea;
    }
    public int maxAreaOpt(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int min = Integer.MAX_VALUE;
        int area = Integer.MIN_VALUE;
        while (right >= left){
            min = Math.min(height[left], height[right]);
            area = Math.max(area, (right - left)*min);
            if(height[left] > height[right]){
                right--;
            } else {
                left++;
            }
        }
        return area;
    }
    public static void main(String[] args) {
        MostWater mostWater = new MostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        // max-area -> maxht*maxwidth
        // maxht -> diff(height[i])
        // maxwidth -> diff(i)
        // maxArea -> diff(i)
        System.out.println(mostWater.maxAreaOpt(height));
    }
}

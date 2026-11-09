    package helloInterview.dsa.problems.twoPointer;

    import java.util.Arrays;

    public class SortColor {
        public void sortColors(int[] nums) {
            int white = 0;
            int red = nums.length - 1;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == 0){
                    int temp = nums[white];
                    nums[white++] = nums[i];
                    nums[i] = temp;
                }
                else if (nums[i] == 2) {
                    int temp = nums[red];
                    nums[red--] = nums[i];
                    nums[i] = temp;
                }
            }
            System.out.println(Arrays.toString(nums));
        }
        public void sortColorsOpt(int[] nums) {
            int white = 0;
            int red = nums.length - 1;
            int i = 0;
            while (i <= red){
                if(nums[i] == 0){
                    int temp = nums[white];
                    nums[white] = nums[i];
                    nums[i] = temp;
                    white++;
                    i++;
                } else if (nums[i] == 2) {
                    int temp = nums[red];
                    nums[red] = nums[i];
                    nums[i] = temp;
                    red--;
                } else {
                    i++;
                }
            }
            System.out.println(Arrays.toString(nums));
        }
        public static void main(String[] args) {
            SortColor sortColor = new SortColor();
            int[] nums = {2,0,2,1,1,0};
            sortColor.sortColorsOpt(nums);
        }
    }

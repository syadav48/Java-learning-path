package leetcode.HashMap;

public class UniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        String[] res = new String[n * 2];
        for (int i = 0; i < n; i++) {
            String s = String.valueOf(i);
            for(int j = 0; j < 2; j++){

            }
        }
        return  "S";

    }
   public static void main(String[] args) {
        UniqueBinaryString uniqueBinaryString = new UniqueBinaryString();
        String[] nums = {"111","011","001"};
       System.out.println(uniqueBinaryString.findDifferentBinaryString(nums));
    }
}

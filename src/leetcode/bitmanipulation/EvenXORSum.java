package leetcode.bitmanipulation;

public class EvenXORSum {
    public int evenNumberBitwiseORs(int[] nums) {
        int result = 0;
        for (int num: nums){
            if((num & 1) == 0){
                result |=  num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        EvenXORSum evenXORSum = new EvenXORSum();
        System.out.println(evenXORSum.evenNumberBitwiseORs(nums));
    }
}

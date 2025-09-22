package leetcode.bitmanipulation;

public class BitManipulation {
    public static void main(String[] args) {
        int n = 5;
        int result = 0;
        int a = 9;
        int b = 5;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("safarnama" + a + " " + b);
        int [] nums = {1, 2, 2, 3, 3, 4, 5, 4, 1};
        if((n & 1) == 1){
            System.out.println("Odd");
        }
        for(int num: nums){
            result ^= num;
        }
        // if in an array you have elements, and every elements repeated twice
        // I want the element that doesnt have repition
        System.out.println(result);

        // toggle a bit
        int bit = 5; // 0101 (binary)
        int i = 2;
        System.out.println(bit ^ (1 << i)); // 0001 (decimal 1)
    }
}

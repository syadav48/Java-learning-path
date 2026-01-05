package leetcode.bitmanipulation;

public class BitManipulation {
    public static void main(String[] args) {
        int n = 5;
        int result = 0;
        int missing = 0;
        int a = 9;
        int b = 5;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("safarnama" + a + " " + b);
        int [] nums = {5, 2, 2, 3, 3, 9};
        int [] arr = {1,2,3,5};
        // 100 & 1 == 0 for Even
        if((n & 1) == 1){

            System.out.println("Odd");
        }
        for(int num: nums){
            result ^= num;
            System.out.println(result + "result");
        }
        // if in an array you have elements, and every elements repeated twice
        // I want the element that doesnt have repition
        for (int i = 0; i < arr.length; i++) {
            missing ^= arr[i];
        }
        System.out.println(result);
        System.out.println(missing + "missing");
        // toggle a bit
        int bit = 5; // 0101 (binary)
        int i = 2;
        System.out.println(bit ^ (1 << i)); // 0001 (decimal 1)
        System.out.println(5 << 1);
        System.out.println(6 >> 1);
        System.out.println(5 ^ 9); // -> 0101 ^ 1001 -> 1100
    }
}

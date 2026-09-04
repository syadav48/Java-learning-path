package helloInterview.dsa.math;

import helloInterview.dsa.sorting.MinimumCost;

public class GcdOfEvenOdd {
    public int[] sumOddEven(int n){
        int sumodd = 0;
        int sumeven = 0;
        for(int i = 1; i <= n; i++){
            sumeven += 2*i;
            sumodd += 2*i - 1;
        }

        return new int[]{sumeven, sumodd};
    }
    public int gcd(int n1, int n2){
        if(n2 == 0){
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
    public int gcdOfOddEvenSums(int n) {
        int[] sums = sumOddEven(n);
        return gcd(sums[0], sums[1]);
    }
    public static void main(String[] args) {
        GcdOfEvenOdd gcdOfEvenOdd = new GcdOfEvenOdd();
        String[] args1 = {"Hi", "Rambo", "Rambo", "Un Un"};
        System.out.println(gcdOfEvenOdd.gcdOfOddEvenSums(4));
        System.out.println(gcdOfEvenOdd.gcdOfOddEvenSums(5));
        System.out.println(gcdOfEvenOdd.gcdOfOddEvenSums(6));
        System.out.println(gcdOfEvenOdd.gcdOfOddEvenSums(14));
        MinimumCost.main(args1);
    }
}

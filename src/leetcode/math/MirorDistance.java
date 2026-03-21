package leetcode.math;

public class MirorDistance {
    public int mirrorDistance(int n) {
        int num = Integer.valueOf(new StringBuilder(Integer.toString(n)).reverse().toString());
        return Math.abs(n - num);
    };
    public static void main(String[] args) {
        MirorDistance mirorDistance = new MirorDistance();
        System.out.println(mirorDistance.mirrorDistance(25));
    }
}

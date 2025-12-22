package leetcode.math;

public class FindCloset {
    public int findClosest(int x, int y, int z) {
        int diff1 = Math.abs(z - x);
        int diff2 = Math.abs(z - y);
        if(diff1 > diff2){
            return 2;
        } else if (diff1 < diff2) {
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        FindCloset findCloset = new FindCloset();
        int x = 1;
        int y = 5;
        int z = 3;
        System.out.println(findCloset.findClosest(x, y, z));
    }
}

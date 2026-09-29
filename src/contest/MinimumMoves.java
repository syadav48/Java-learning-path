package contest;

import java.util.Arrays;

public class MinimumMoves {
    public int minQueenMoves(int[] source, int[] target) {
        if(Arrays.equals(source, target)) return 0;
        if(source[0] == target[1] || target[0] == source[1]){
            return 1;
        }
        if(source[0] == target[0] || target[1] == source[1]){
            return 1;
        }
        int n = source.length;
        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = source[n - 1 - i];
        }
        if(Arrays.equals(reversed, target)) return 1;
        if(Arrays.stream(source).sum() == Arrays.stream(target).sum()) return 1;
        return 2;
    }

    public static void main(String[] args) {
        MinimumMoves moves = new MinimumMoves();
        int[] source = new int[]{4,2};
        int[] target = new int[]{1,3};
        System.out.println(moves.minQueenMoves(source, target));
    }
}

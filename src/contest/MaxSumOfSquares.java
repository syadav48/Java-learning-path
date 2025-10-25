package contest;

public class MaxSumOfSquares {
    public static String maxSumOfSquares(int num, int sum) {
        int drevantor = sum;
        if (sum > 9 * num || sum < 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int digit = Math.min(9, sum);
            sb.append(digit);
            sum -= digit;
        }
        if (sum != 0) return "";
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(maxSumOfSquares(2,3));
    }

}

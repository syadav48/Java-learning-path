package leetcode.twoPointer;

public class MinFlip {
    public int minimumFlips(int n) {
        String bStr = Integer.toBinaryString(n);
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (int i = bStr.length() - 1; i >= 0; i--) {
            builder.append(bStr.charAt(i));
        }
        for (int i = 0; i < bStr.length(); i++) {
            if(bStr.charAt(i) != builder.charAt(i)){
                count++;
            }
        }
        return count;
    }
    public int otpimumMinimumFlips(int n) {
        String bStr = Integer.toBinaryString(n);
        int left = 0;
        int right = bStr.length() - 1;
        int count = 0;

        while (left < right) {
            if (bStr.charAt(left) != bStr.charAt(right)) {
                count += 2; // both sides mismatch
            }
            left++;
            right--;
        }
        return count;
    }

    public static void main(String[] args) {
        MinFlip minFlip = new MinFlip();
        System.out.println(minFlip.minimumFlips(7));
    }
}

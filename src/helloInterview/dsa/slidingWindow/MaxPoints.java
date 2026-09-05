package helloInterview.dsa.slidingWindow;

import java.util.Arrays;

public class MaxPoints {
    public int maxScore(int[] cardPoints, int k) {
        int sum = Arrays.stream(cardPoints).sum();
        int n = cardPoints.length;
        int winLength = n - k;
        int winSum = 0;
        int minSum = 0;
        for(int i = 0; i < winLength; i++){
            winSum += cardPoints[i];
        }
        minSum = winSum;
        for(int i = k + 1; i < n; i++){
            winSum = winSum + cardPoints[i] - cardPoints[i - k - 1];
            minSum = Math.min(minSum, winSum);
            System.out.println("Adding: " + cardPoints[i] +
                    " Subtracting: " + cardPoints[i - k - 1] + "winSum: " + winSum + "minSum: " + minSum + "sum:  " + sum);


        }

        return sum - minSum;

    }
    // Use a fixed window length problem, of size n - k, the minimum sum of any executive n - k cards
    // calc: sum - window_sum and track the maximum
    public int maxScoreOpt(int[] cardPoints, int k) {
        int sum = Arrays.stream(cardPoints).sum();
        int n = cardPoints.length;
        if(k == n){
            return sum;
        }
        int state = 0;
        int maxPoints = 0;
        int start = 0;
        for(int end = 0;  end < n; end++){
            state += cardPoints[end];
            if(end - start + 1 == n - k){
                maxPoints = Math.max(sum - state, maxPoints);
                state -= cardPoints[start];
                start++;
            }
        }
        return maxPoints;

    }
    public static void main(String[] args) {
        MaxPoints maxPoints = new MaxPoints();
        int[] cardPoints = {2,11,4,5,3,9,2};
        int[] cardPoints1 = {1,2,3,4,5,6,1};
        int[] cardPoints4 = {1,79,80,1,1,1,200,1};
        int[] cardPoints5 = {100,40,17,9,73,75};

        int k = 3;
        System.out.println(maxPoints.maxScoreOpt(cardPoints, k));
        System.out.println(maxPoints.maxScoreOpt(cardPoints1, k));
        System.out.println(maxPoints.maxScoreOpt(cardPoints4, k));
        System.out.println(maxPoints.maxScoreOpt(cardPoints5, k));
    }
}

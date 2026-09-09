package helloInterview.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
               int index = stack.pop();
               res[index] = i - index;
            }
            stack.push(i);
        }

        System.out.println(Arrays.toString(res));
        return res;
    }
    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        dailyTemperatures.dailyTemperatures(temperatures);
    }
}

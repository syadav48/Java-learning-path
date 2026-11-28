package helloInterview.dsa.problems.stackQueue;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
         Deque<Integer> stack = new ArrayDeque<>();
         int[] res = new int[temperatures.length];
         for (int i = 0; i < temperatures.length; i++){
             while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                 int index = stack.pop();
                 // res[i] - currentIndex - previousIndex
                 res[index] =  i - index;
             }
             stack.push(i);
         }
         return res;
    }
    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        // 1,1,4,2,1,1,0,0;
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(temperatures)));
    }
}

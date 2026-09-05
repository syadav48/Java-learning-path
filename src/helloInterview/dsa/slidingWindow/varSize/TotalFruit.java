package helloInterview.dsa.slidingWindow.varSize;

import java.util.HashMap;
import java.util.Map;

public class TotalFruit {
    public int totalFruit(int[] fruits){
        int start = 0;
        Map<Integer, Integer> basket = new HashMap<>();
        int maxFruit = 0;
        for(int end = 0; end < fruits.length; end++){
            basket.put(fruits[end], basket.getOrDefault(fruits[end], 0) + 1);
            while (basket.size() > 2){
                basket.put(fruits[start], basket.get(fruits[start]) - 1);
                if(basket.get(fruits[start]) == 0){
                    basket.remove(fruits[start]);
                }
                start++;
            }
            maxFruit = Math.max(maxFruit, end - start + 1);
        }
        return maxFruit;
    }
    public static void main(String[] args) {
        TotalFruit fruit = new TotalFruit();
        int[] fruits = {1,2,3,2,2};
        System.out.println(fruit.totalFruit(fruits));
    }
}

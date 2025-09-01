package leetcode.HashMap;

import java.util.HashMap;
import java.util.Map;

public class IsHappy {

    private int addSquare(int n){
        int sum = 0;
        while (n > 0){
            int digit = n % 10;
            sum += digit * digit;
            n = n/10;
        }
        return sum;
    }
    private boolean isHappyHelper(int n, Map<Integer, Boolean> map){
        if(n == 1) return true;
        if(map.containsKey(n)) return  false;
        map.put(n, true);
        int res = addSquare(n);
        return isHappyHelper(res, map);
    }
    public boolean isHappy(int n) {
        return isHappyHelper(n, new HashMap<>());
    }


    public static void main(String[] args) {
        IsHappy obj = new IsHappy();
        System.out.println(obj.isHappy(2));
    }
}

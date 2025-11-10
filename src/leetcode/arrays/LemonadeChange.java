package leetcode.arrays;

import java.util.*;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int bill: bills){
            if(bill == 5){
                five++;
            } else if (bill == 10) {
                if(five > 0){
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                } else if (five > 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }

        }
        return true;
    };
    public static void main(String[] args) {
        int[] bills = {5,5,5,10,20};
       // int[] bills1 = {5,5,10,10,20};
        LemonadeChange lemonadeChange = new LemonadeChange();
        System.out.println(lemonadeChange.lemonadeChange(bills));
        //System.out.println(lemonadeChange.lemonadeChange(bills1));
    }
}

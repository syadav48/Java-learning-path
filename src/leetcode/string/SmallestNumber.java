package leetcode.string;

import java.util.*;
import java.util.stream.Stream;

public class SmallestNumber {
    public String smallestNumber(String pattern) {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        int streakI = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i) == 'I'){
                stringBuilder1.append(streakI);
                streakI++;
            } else {
                list.add(i + 1);
            }
        }
        for (int i = 0; i < list.size(); i++) {

        }
        System.out.println(stringBuilder2.toString());
        System.out.println(list);
        return stringBuilder1.toString();
    };
    public String optimizedSmallestNumber(String pattern) {
         StringBuilder result = new StringBuilder();
         Stack<Integer> stack = new Stack<>();
         int num = 1;
        for (int i = 0; i < pattern.length(); i++) {
            stack.push(num++);
            if(pattern.charAt(i) == 'I'){
                while (!stack.isEmpty()){
                    result.append(stack.pop());
                }
            }
        }
        stack.push(num);
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.toString();
    };


    public static void main(String[] args) {
        SmallestNumber smallestNumber = new SmallestNumber();
        String string = "IIIDIDDD"; //123 5 4 9876
        //easy qn: I -> 12, II-> 123, III -> 1234
        //easy qn: D -> 21, DD-> 321, DDD -> 4321
        //easy qn: ID -> 123, DD-> 321, DDD -> 4321

        System.out.println(smallestNumber.optimizedSmallestNumber(string));
    }
}

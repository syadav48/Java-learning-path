package JavaCollectionTutorial.List.Stack;

import java.util.ArrayDeque;
import java.util.stream.Collectors;

public class Q1_Stack {
    public static void reversed(String str){
        ArrayDeque<String> stack = new ArrayDeque<>();
        for(String ch: str.split("")){
            stack.push(ch);
        }
        String res1 = String.join("", stack);
        String res2 = stack.stream().collect(Collectors.joining(""));
        System.out.println(res1);
        System.out.println(res2);

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()){
            reversed.append(stack.pop());
        }
        System.out.println(reversed);

    }
    public static void main(String[] args) {
        String str = "hello";
        reversed(str);

    }
}

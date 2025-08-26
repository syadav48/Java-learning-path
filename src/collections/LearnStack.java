package collections;

import java.util.Stack;

public class LearnStack {
    public static void main(String[] args) {
        Stack<String> animals = new Stack<>();
        animals.add("Lion");
        animals.add("Elephant");
        animals.add("Tiger");
        animals.add("Fox");
        animals.add("Deer");
        System.out.println(animals.peek());
        System.out.println(animals.pop());
        System.out.println(animals.search("Elephant"));
        System.out.println(animals.push("Dog"));
        System.out.println(animals);
    }
}

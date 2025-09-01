package stream;

import java.util.function.Predicate;

public class LearnPredicate {
    public static void main(String[] args) {
//        Predicate --> Functional Interface (Boolean valued function);
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(4));
        Predicate<String> isWordStartingwithA = x -> x.toLowerCase().startsWith("a");
        Predicate<String> isWordEndingwithA = x -> x.toLowerCase().endsWith("a");
        Predicate<String> and = isWordEndingwithA.and(isWordStartingwithA);
        System.out.println(and.test("Angit"));
    }
}

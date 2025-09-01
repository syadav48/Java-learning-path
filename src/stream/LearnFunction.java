package stream;

import java.util.function.Function;

public class LearnFunction {
    public static void main(String[] args) {
        // Function works for you
        Function<Integer, Integer> doubleIt = x -> x * 2;
        Function<Integer, Integer> tripleIt = x -> x * 3;
        System.out.println(doubleIt.apply(100));
        System.out.println(doubleIt.andThen(tripleIt).apply(200));
        System.out.println(doubleIt.compose(tripleIt).apply(300));
        System.out.println(doubleIt.equals(tripleIt));

        Function<Integer, Integer> identity = Function.identity();
        Integer res2 = identity.apply(5);
        System.out.println(res2);

    }
}

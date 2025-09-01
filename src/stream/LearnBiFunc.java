package stream;

import java.util.function.*;

public class LearnBiFunc {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
        System.out.println(isSumEven.test(5, 5));
        BiConsumer<Integer, String> biConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        BiFunction<String, String, Integer> biFunction = (x, y) -> (x + y).length();
        System.out.println(biFunction.apply("a","bc"));

        UnaryOperator<Integer> a = x -> x * x;
        BinaryOperator<Integer> b = (x, y) -> x + y;
    }
}

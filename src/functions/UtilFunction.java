package functions;
//https://chatgpt.com/c/68b72cc4-01a4-8333-9d6d-d4716e61bd88
import java.util.function.*;

public class UtilFunction {
    public static void main(String[] args) {
        Function<Integer, Integer> doublet = (x) -> 2 * x;
        System.out.println(doublet.apply(5));
        Function<String, Integer> checkLen = String::length;
        System.out.println(checkLen.apply("Surya"));
        Predicate<String> isEmpty = (x) -> x.length() > 0;
        System.out.println(isEmpty.test("Surya"));

        Predicate<Integer> isPrime = (num) -> {
            if(num == 1 || num == 2) return  true;
            for(int i = 3; i < Math.sqrt(num); i = i + 2){
                if(num % i == 0) return false;
            }
            return true;
        };

        System.out.println(isPrime.test(419));
        Consumer<String> prefixHello = (str) -> System.out.println("Hello" + " " + str);
        prefixHello.accept("Rahul");
        Supplier<Double> genRandom = Math::random;
        System.out.println(genRandom.get());
        Function<Integer, Integer> makeDouble = (x) -> 2 * x;
        Function<Integer, Integer> makeSquare = (x) -> x * x;
        System.out.println(makeDouble.andThen(makeSquare).apply(5));

        BiFunction<Integer, Integer, Integer> addTwo = Integer::sum;
        System.out.println(addTwo.apply(5,6));

        UnaryOperator<Integer> incrementOne = (x) -> x + 1;
        System.out.println(incrementOne.apply(4));

        BinaryOperator<String> concatStr = String::concat;
        System.out.println(concatStr.apply("Surya", "Sangita"));

    }
}

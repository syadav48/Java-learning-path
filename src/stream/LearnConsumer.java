package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LearnConsumer {
    public static void main(String[] args) {
        Consumer<Integer> print = x -> System.out.println(x);
        print.accept(51);
        List<Integer> list = Arrays.asList(1, 2, 3);
        Consumer<List<Integer>> printlist = x -> {
            for(int i: x){
                System.out.println(i);
            }
        };
        printlist.accept(list);

        // Supplier - not taking any arguments always return something
        Supplier<String> giveHelloWorld = () -> "Hello World";
        System.out.println(giveHelloWorld.get());

        // combined example:
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> func = x -> x * x;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Supplier<Integer> supplier = () -> 100;

        if(predicate.test(supplier.get())){
            consumer.accept(func.apply(supplier.get()));
        }
    }


}

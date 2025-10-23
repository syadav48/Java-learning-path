package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {
    public static void main(String[] args) {
        IntegerCounter integerCounter = new IntegerCounter(1);
        DoubleCounter dbCounter = new DoubleCounter(100.0555);
        Counter<Integer> counter1 = new Counter<>(10);
        Counter<Double> counter2 = new Counter<>(104.04);
        //Counter<String> counter3 = new Counter<>("ABC"); Type is bound to Number class only
        // only class defined inside diamond op: not primitive type
        //<> --> diamond operator
        integerCounter.print();
        dbCounter.print();
        counter1.print();
        counter2.print();
       print("Shama", "Dev");
       print(1, 2);
       List<Object> list = new ArrayList<>();
       list.add(1);
       print(list);
    }
    public static <T, U> T print(T t, U u){
        System.out.println(t);
        System.out.println(u);
        return t;
    }
    //wildcard characterstics of generic
    public static void print(List<?> list){
        System.out.println(list);
    }
}

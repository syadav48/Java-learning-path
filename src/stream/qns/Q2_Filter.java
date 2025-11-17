package stream.qns;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q2_Filter {
    public static boolean isPrime(int num){
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i = i + 2) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //1
        List<Integer> list = DataFactory.numbers();
        var primeList = list.stream().filter(Q2_Filter::isPrime).toList();

        //2
        List<String> list1 = DataFactory.employees().stream().filter(x -> x.getSalary() > 50000)
                .map(Employee::getName).toList();
        System.out.println(primeList);
        System.out.println(list1);

        //3
        Stream<Optional<String>> list2 = DataFactory.optionalStrings().stream().filter(x -> x.isPresent());
        System.out.println(list2.toList());

        //4
        List<Double> amounts = DataFactory.transactions().stream().filter(x -> x.getType() == Transaction.Type.CREDIT)
                .map(Transaction::getAmount).toList();
        System.out.println(amounts);



    }
}

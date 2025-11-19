package stream.qns;

import java.util.Arrays;
import java.util.Optional;

public class Q6_Matching {
    public static void main(String[] args) {
        // 1
        boolean isNegative = Arrays.stream(DataFactory.numberArray()).boxed().anyMatch(x -> x < 0);
        boolean isNegativeList = DataFactory.numbers().stream().anyMatch(x -> x < 0);
        System.out.println(isNegative);
        System.out.println(isNegativeList);

        //2
        boolean aboveEighteen = DataFactory.employees().stream().anyMatch(x -> x.getAge() > 18);
        System.out.println(aboveEighteen);

        //3
        boolean isEmptyString = DataFactory.optionalStrings().stream().anyMatch(Optional::isEmpty);
        System.out.println(isEmptyString);

        //4
        boolean isRefundTransaction = DataFactory.transactions().stream().anyMatch(x -> x.getType().equals(Transaction.Type.REFUND));
        System.out.println(isRefundTransaction);

        //5
    }
}

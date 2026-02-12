package stream.qns;

import java.util.Arrays;
import java.util.List;

public class Q14_R1Filter_Map {
    public static void main(String[] args) {
        List<String> credit = DataFactory.transactions().stream().filter(
                x -> x.getType().equals(Transaction.Type.CREDIT)
        ).map(Transaction::getTxnId).toList();
        System.out.println(credit);

        List<String> list = DataFactory.sentences().stream().map(
                x -> x.split(" ")
        ).flatMap(Arrays::stream).toList();

        System.out.println(list);

        List<String> list1 = DataFactory.employees().stream().map(x -> x.getSkills())
                .flatMap(
                        x -> x.stream().distinct()
                ).toList();

        System.out.println(list1);
    }
}

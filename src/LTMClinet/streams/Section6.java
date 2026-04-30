package LTMClinet.streams;

import stream.qns.DataFactory;
import stream.qns.Transaction;

public class Section6 {
    public static void main(String[] args) {
        boolean match1 = DataFactory.numbers().stream().anyMatch(x -> x < 0);
        boolean match2 = DataFactory.employees().stream().allMatch(x -> x.getAge() > 18);
        boolean match3 = DataFactory.transactions().stream().anyMatch(x -> x.getType().equals(Transaction.Type.REFUND));
        System.out.println(match1);
        System.out.println(match2);
        System.out.println(match3);
    }
}

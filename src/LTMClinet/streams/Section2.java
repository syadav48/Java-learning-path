package LTMClinet.streams;

import company.mockdata.DataFactory;
import stream.qns.Transaction;

import java.util.List;

public class Section2 {
    public static boolean checkPrime(int n){
        if(n == 2 || n == 3) return true;
        if(n % 2 == 0 || n < 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        List<Integer> list = DataFactory.integerList.stream().filter(x -> checkPrime(x)).distinct().toList();
        System.out.println(list);
        List<String> list1 = DataFactory.getEmployees().stream().
                filter(x -> x.getSalary() > 50000).map(x -> x.getName()).toList();
        System.out.println(list1);
        List<String> list2 = stream.qns.DataFactory.transactions().stream().filter(x -> x.getType().equals(Transaction.Type.CREDIT))
                .map(x -> x.getTxnId()).toList();
        System.out.println(list2);
    }
}

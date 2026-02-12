package Interview;

import stream.qns.DataFactory;
import stream.qns.Transaction;

import java.util.Comparator;
import java.util.stream.Collectors;


public final class InterviewQns {
    public final String makingSingleton(){
        return "Hi SIngleton";
    }
    public static void main(String[] args) {
        int summed = DataFactory.transactions().stream().mapToInt(x -> (int) x.getAmount()).sum();
        DataFactory.transactions().stream().mapToInt(x -> (int) x.getAmount()).sorted().mapToLong(x -> x).toArray();
        System.out.println(summed);

        //Service
        // bpaUpdate -> BPAUpdate
        // configuration class
        // return BPAUpdate Bean
        // @Before("logchekre)
        // logcheker(req) -> log.info -> req



    }
}

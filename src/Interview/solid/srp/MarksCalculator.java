package Interview.solid.srp;

import java.util.List;

public class MarksCalculator {
    public int sum(List<Integer> marks){
        return marks.stream().mapToInt(x -> x).sum();
    }
    public double average(List<Integer> marks){
        return marks.stream()
                .mapToInt(x -> x)
                .average()
                .orElse(0);
    }
}

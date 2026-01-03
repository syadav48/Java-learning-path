package Interview.solid.srp;

import java.util.List;

public class ResultApplication {
    public static void main(String[] args) {
        List<Integer> marks = List.of(95,67,78,45,86);
        MarksCalculator marksCalculator = new MarksCalculator();
        ResultDecider resultDecider = new ResultDecider();
        ResultPrinter resultPrinter = new ResultPrinter();
        ResultRepository resultRepository = new ResultRepository();

        int total = marksCalculator.sum(marks);
        double avg = marksCalculator.average(marks);
        String status = resultDecider.decide(avg);

        Result result = new Result(total, avg, status);
        resultPrinter.print(result);

        resultRepository.save(1, result);

        resultRepository.get(1);

    }
}

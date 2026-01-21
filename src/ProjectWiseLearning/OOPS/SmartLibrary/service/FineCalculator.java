package ProjectWiseLearning.OOPS.SmartLibrary.service;

public class FineCalculator {

    private double rate = 2.0;

    class Helper {
        void calculate(double rate) { // shadowing
            System.out.println(rate * 5);
        }
    }
}


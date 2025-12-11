package Interview.javaCore.interfaceExample;

public class MinusCalculator implements CalCulator{
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subStraction(int a, int b) {
        return a - b - 1;
    }
}

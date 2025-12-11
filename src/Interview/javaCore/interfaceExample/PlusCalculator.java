package Interview.javaCore.interfaceExample;

public class PlusCalculator implements CalCulator{

    @Override
    public int add(int a, int b) {
        return a + b + 1;
    }

    @Override
    public int subStraction(int a, int b) {
        return a - b;
    }
}

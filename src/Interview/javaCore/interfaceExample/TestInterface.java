package Interview.javaCore.interfaceExample;

public class TestInterface {
    public static void main(String[] args) {
        CalCulator calCulator = new PlusCalculator();
        System.out.println(calCulator.add(8, 5));;
        System.out.println(calCulator.subStraction(9, 5));;
        CalCulator minusCalculator = new MinusCalculator();
        System.out.println(minusCalculator.subStraction(7, 6));
        System.out.println(minusCalculator.add(9, 3));
    }
}

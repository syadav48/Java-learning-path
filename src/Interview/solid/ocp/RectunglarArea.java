package Interview.solid.ocp;

public class RectunglarArea implements AreaCalculator{
    private final int length;
    private final int breadth;

    public RectunglarArea(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double area() {
        return length*breadth;
    }
}

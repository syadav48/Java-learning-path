package Interview.solid.ocp;

public class CircularArea implements AreaCalculator {
    private final int radius;
    public CircularArea(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }
}

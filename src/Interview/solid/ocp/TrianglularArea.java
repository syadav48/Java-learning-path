package Interview.solid.ocp;

public class TrianglularArea implements AreaCalculator {
    private final int base;
    private final int height;

    public TrianglularArea(int base, int height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return .5*base*height;
    }
}

package Interview.solid.ocp;

import java.util.List;

public class AreaResults {
    public static void main(String[] args) {
        int radius = 5;
        int length = 4;
        int breadth = 8;
        CircularArea circularArea = new CircularArea(radius);
        TrianglularArea trianglularArea = new TrianglularArea(length, breadth);
        RectunglarArea rectunglarArea = new RectunglarArea(length, breadth);
        double result = new AreaService().totalArea( List.of(
                circularArea, trianglularArea, rectunglarArea
        ));
        System.out.println(result);
    }
}

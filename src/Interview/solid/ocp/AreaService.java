package Interview.solid.ocp;

import java.util.List;

public class AreaService {
    public double totalArea(List<AreaCalculator> shapes){
        return shapes.stream()
                .mapToDouble(AreaCalculator::area)
                .sum();
    }
}

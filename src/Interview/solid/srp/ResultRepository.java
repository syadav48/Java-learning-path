package Interview.solid.srp;

import java.util.HashMap;
import java.util.Map;

public class ResultRepository {
    private Map<Integer, Result> resultMap = new HashMap<>();

    public void save(int studentId, Result result) {
        resultMap.put(studentId, result);
    }

    public Result get(int studentId) {
        return resultMap.get(studentId);
    }
}

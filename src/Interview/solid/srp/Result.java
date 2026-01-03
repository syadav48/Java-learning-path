package Interview.solid.srp;

public class Result {
    public final int total;
    public final double average;
    public final String status;

    public Result(int total, double average, String status) {
        this.total = total;
        this.average = average;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Result{" +
                "total=" + total +
                ", average=" + average +
                ", status='" + status + '\'' +
                '}';
    }
}

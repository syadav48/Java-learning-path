package helloInterview.dsa.string;

public class TrafficSignal {
    public String trafficSignal(int timer) {
        if(timer == 0){
            return "Green";
        } else if (timer == 30) {
            return "Orange";
        } else if (timer > 30 && timer <= 90) {
            return "Red";
        } else {
            return "Invalid";
        }
    }
    public static void main(String[] args) {
        TrafficSignal trafficSignal = new TrafficSignal();
        System.out.println(trafficSignal.trafficSignal(5));
    }
}

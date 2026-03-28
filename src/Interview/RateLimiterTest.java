package Interview;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

public class RateLimiterTest implements RateLimiter{
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    LocalTime localTime = LocalTime.now();
    @Override

    public boolean rateLimit(int customerId) {
        int count =  hashMap.getOrDefault(customerId, 0) + 1;
        boolean time1 = localTime.isAfter(LocalTime.of(0, 0, 5));

        if(count > 5 && time1){
            return false;
        } else {
            hashMap.put(customerId, count);
        }
        return true;
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiterTest();
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
        System.out.println(rateLimiter.rateLimit(1));
    }
}

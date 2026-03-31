package Interview;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class InterviewQn {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 5, 6, 7, 8); // odd value -> string x :
        List<? extends Serializable> list1 = list.stream().map(x -> x % 2 == 0 ? x : "x").toList();
        System.out.println(list1);
        //@Async -> Servivce Completable
        // disablity -> @exclude
        // ISR -> Instinct Replica
        // Leader and follower ->
        // SELECT *, COUNT(email_id) AS count FROM EMPLOYEE
        // GROUP BY email_id
        // HAVING count > 1
        // Reconcilation ->
        // useLayoutEffect
        //
    }

}

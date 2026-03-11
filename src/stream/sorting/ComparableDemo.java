package stream.sorting;

import java.util.Collections;
import java.util.List;

public class ComparableDemo {
    public static void main(String[] args) {
        List<Student> students = new java.util.ArrayList<>(List.of(
                new Student("Rahul", 19),
                new Student("Viki", 20),
                new Student("Surya", 18)
        ));
        Collections.sort(students);
        System.out.println(students);
    }
}

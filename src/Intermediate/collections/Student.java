package Intermediate.collections;

import java.util.*;

public class Student {
    private  String name;
    private int marks;
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    public String getName(){
        return name;
    }
    public int getMarks(){
        return marks;
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice", 85);
        Student s2 = new Student("Bob", 90);
        Student s3 = new Student("Manu", 80);
        Student s4 = new Student("Ganesh", 95);
        Student s5 = new Student("Charlie", 70);
        Student s6 = new Student("Eve", 88);
        Student s7 = new Student("David", 92);
        Student s8 = new Student("Frank", 75);
        Student s9 = new Student("Grace", 89);
        Student s10 = new Student("Heidi", 78);
        List<Student> studentss = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10);
        List<Student> newList =  studentss.stream().sorted(Comparator.comparing(Student::getMarks)).toList();
        Student students[] = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10};
        Arrays.sort(students, Comparator.comparingInt(Student::getMarks).reversed());
        for (Student s : students) {
            System.out.println(s.getName() + " : " + s.getMarks());
        };

        //
        List<Student> descending = studentss.stream()
                .sorted(Comparator.comparingInt(Student::getMarks).reversed())
                .toList();
        List<Student> ascending = studentss.stream()
                .sorted(Comparator.comparingInt(Student::getMarks))
                .toList();
    }
}

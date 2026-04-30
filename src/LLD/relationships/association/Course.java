package LLD.relationships.association;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String title;
    private List<Student> students;
    private Instructor instructor;

    public Course(String title, Instructor instructor) {
        this.title = title;
        this.instructor = instructor;
        this.students = new ArrayList<>();
    }

    public void enrollStudent(Student student){
        students.add(student);
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public String getTitle() {
        return title;
    }
}

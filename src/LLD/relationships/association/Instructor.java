package LLD.relationships.association;

import java.util.ArrayList;
import java.util.List;

public class Instructor {
    private String name;
    private List<Course> courses;
    private Course course;

    public Instructor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }
    public void addCourse(Course course){
        courses.add(course);
    }
}

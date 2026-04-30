package LLD.relationships.association;

public class Student {
    private String name;
    private Course course;

    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
        this.course.enrollStudent(this);
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }
    public String getInstructorName(){
        return course.getInstructor().getName();
    }
}

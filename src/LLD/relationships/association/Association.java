package LLD.relationships.association;

public class Association {
    public static void main(String[] args) {
        Instructor instructor1 = new Instructor("PremLata");
        Instructor instructor2 = new Instructor("Shyam Singh");

        Course course1 = new Course("PCM", instructor1);
        Course course2 = new Course("Commerce", instructor2);

        Student student1 = new Student("Prince", course1);
        Student student2 = new Student("Dushyant", course2);
        System.out.println(student1.getName() + "  " +
                "selected the course of " + student1.getCourse().getTitle() + " from the instructor: "
                + student1.getInstructorName());

        System.out.println(student2.getName() + "  " +
                "selected the course of " + student2.getCourse().getTitle() + " from the instructor: "
                + student1.getInstructorName());

    }
}

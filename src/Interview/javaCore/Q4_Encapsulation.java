package Interview.javaCore;

class Student{
     private int marks;
     // if you make it public, anyone can directly acess it and modify it, causes data overiding from anywher:
    // student.marks = 103
    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
public class Q4_Encapsulation {
    public static void main(String[] args) {
        Student student = new Student();
        student.setMarks(85);
        System.out.println(student.getMarks());


    }
}

package Interview.javaCore;

class Student1 {
    int marks;
}

class Test1{
    private int marks;
    public static void modify(Student1 s) {
        s.marks = 90;  // modifies object
    }
    public static void changeVal(int x){
        x = 20;
    }
}

public class Q12_PassByRefVal {

    public static void main(String[] args) {
        int x = 10;
        // pass by value
        Test1 test1 = new Test1();
        Student1 student1 = new Student1();
        student1.marks = 40;
        Test1.changeVal(x);
        // pass by reference
        Test1.modify(student1);
        System.out.println(x + " " + test1 + " " + student1.marks);
        ImmutableObject immutableObject = new ImmutableObject("Imm2");
        System.out.println(immutableObject.getImmutable());
    }
}



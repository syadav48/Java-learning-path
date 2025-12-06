package Interview.javaCore;

class Animal{
    void speak(){
        System.out.println("animal speaks");
    }
}
class Dog extends Animal{
    void bark(){
        System.out.println("dog barks");
    }
}
//java supports single inheritance with classes but multiple inheritance with interface;
public class Q4_Inheritance {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark();
        dog.speak();
        Student student = new Student();
//        student.marks = 100 -> direct access if it would have public
        student.setMarks(100);

    }
}

package Interview.javaCore;

class ThisExample01{
    private String name;
    private int age;
    private String course;

    ThisExample01(){
        this("Unknown");
        System.out.println("Inside no-arg constructor");
    }
    ThisExample01(String name){
        this(name, 23);
        System.out.println("Inside 1-arg constructor");
    }
    ThisExample01(String name, int age){
        this(name, age, "Maths");
        System.out.println("Inside 2-arg constructor");
    }
    ThisExample01(String name, int age, String course){
        this.name = name;
        this.age = age;
        this.course = course;
        System.out.println("Inside 3-arg constructor");
    }
}

public class Q18_ThisExample {
    public static void main(String[] args) {
        ThisExample01 thisExample01 = new ThisExample01();
    }
}

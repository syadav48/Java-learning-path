package Interview.javaCore;

abstract class Shape1 {

    String color;

    Shape1() {                     // abstract class constructor
        this.color = "Red";
        System.out.println("Shape constructor called");
    }

    abstract void draw();
}

class Circle1 extends Shape1 {

    Circle1() {
        System.out.println("Circle constructor called");
    }

    @Override
    void draw() {
        System.out.println("Drawing Circle in " + color + " color");
    }
}



public class Q19_AbstractClass {
    public static void main(String[] args) {
        Circle1 c = new Circle1();
        c.draw();
    }
}

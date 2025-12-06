package Interview.javaCore;

abstract class Shape{
    abstract void draw();
}
class Circle extends Shape{
    void draw(){
        System.out.println("drawing circle");
    }
}

public class Q6_Abstraction {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.draw();
    }
}

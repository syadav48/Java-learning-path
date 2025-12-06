package Interview.javaCore;
// method overloading:

class Calculator{
    // Overloaded method #1
    int add(int a, int b) {
        return a + b;
    }

    // Overloaded method #2
    double add(double a, double b) {
        return a + b;
    }

    // Overloaded method #3
    int add(int a, int b, int c) {
        return a + b + c;
    }
}
class Computer{
    void print(){
        System.out.println("printing");
    }
}
class Laptop extends Computer{
    void print(){
        System.out.println("print laptop");
    }
}
class Macbook extends Computer{
    void print(){
        System.out.println("print macbook");
    }
}

public class Q5_Polymorphisam {
    public static void main(String[] args) {

//        When multiple methods have the same name but different signatures.
//        The method call is resolved by the compiler.
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(5, 6));
        System.out.println(calculator.add(5, 6, 8));
        System.out.println(calculator.add(5.334, 6.9));



//        When a subclass provides its own implementation of a method in the parent class.
//        The correct method is chosen at runtime based on the object.
        Computer c;
        c = new Laptop();
        c.print();
        c = new Macbook();
        c.print();
    }
}

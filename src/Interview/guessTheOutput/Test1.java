package Interview.guessTheOutput;

class A {
    A() {
        this(10);
        System.out.println("A()");
    }

    A(int x) {
        System.out.println("A(int)");
    }
}

public class Test1 {
    public static void main(String[] args) {
        new A();
        // int, ()
    }
}

package Interview.guessTheOutput;

class AB {
    AB() {
        System.out.println("A()");
    }
}

class B extends AB {
    B() {
        this("Hello");
        System.out.println("B()");
    }

    B(String s) {
        System.out.println("B(String)");
    }
}


public class Test2 {
    public static void main(String[] args) {
        new B();
        // B(String)
        // B()

    }
}

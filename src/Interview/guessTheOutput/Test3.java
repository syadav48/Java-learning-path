package Interview.guessTheOutput;

class Example {
    Example() {
        this(5);
        System.out.println("Default");
    }

    Example(int x) {
       // this()
        //compile-time error
        // infinite constructor recursion
        System.out.println("Param");
    }
}

public class Test3 {
    public static void main(String[] args) {
        new Example();
    }
}

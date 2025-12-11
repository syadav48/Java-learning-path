package Interview.guessTheOutput;

class P {
    P() {
        System.out.println("P()");
    }
}

class C extends P {

    C() {
        this(5);
        System.out.println("C()");
    }

    C(int x) {
        System.out.println("C(int)");
    }

}



public class Test4 {
    public static void main(String[] args) {
        new C();
        //P()
        //C(int)
        //C()
    }
}

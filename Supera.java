class A extends Object {
    public A() {
        super();
        // what is the super of this class, because its the uppermost
        // so, every class in java is an extenstion of Object
        System.out.println("in A");
    }

    public A(int a) {
        super();
        System.out.println("in parametrized A");
    }

}

class B extends A {
    public B() {
        //call the constructor of the super class
        super();
      
        System.out.println("in B");
    }
    public B(int b) {
        //super(); 
        // calling A without any parameter -> super()
        super(5);
        // this(); - this will call the both the constructor
        // explicitely if you want to put some value, then parameterized one will be called
        System.out.println("in parametrized B");
    }
}

public class Supera {
    public static void main(String[] args) {
        B obj = new B(5);
    }
}

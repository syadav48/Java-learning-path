package Interview.outputbasedjava.string;

class A{
    A(){
        System.out.println("in A constructor");
    }
}
class B extends A{
    B(){

        System.out.println("in B constructor");
    }
}
public class ConstructorExecution {
    public static void main(String[] args) {
        new B();
    }
}

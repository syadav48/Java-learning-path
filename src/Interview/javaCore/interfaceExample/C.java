package Interview.javaCore.interfaceExample;

 interface A {
    default void show(){
        System.out.println("In A");
    }
}
 interface B {
    default void show(){
        System.out.println("In B");
    }
}
public class C implements A, B{

    @Override
    public void show() {
        B.super.show();
        A.super.show();
        System.out.println("in C");
    }
}


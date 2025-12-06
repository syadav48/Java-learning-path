package Interview.javaCore;

class GrandParent{
    private A a;
    GrandParent(A a){
        this.a = a;
        System.out.println("calling great grand parent");
    }
}
class Parent extends GrandParent{
    int y;
    Parent(){
        this(10);
        System.out.println("calling constructor");
    }
    Parent(int x){
        super(new A());
        y = x;
        System.out.println("logging the value of " + x + " " + y);
    }
}

class A {
    A() { System.out.println("A in the parent one"); }
}

class B extends A {
    B() { super(); System.out.println("B"); }
}

class C extends B {
    C() { System.out.println("C"); }
}
class A1 {
    int x = 10;
    A1() {
        System.out.println(x);
        x = 20;
    }
}
class B1 extends A1 {
    int x = 30;
    B1() {
        System.out.println(x);
    }
}




public class Q8_Constructor {

    public static void main(String[] args) {
        Parent parent = new Parent();
        //super is used to call the parent constructor
        // and this is used to call the constructor of the same class
        new C();
        new B1();
    }
}

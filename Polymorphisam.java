class A 
{
    public  void show() 
    {
        System.out.println("in A");
    }
}

class B extends A 
{
    public void show() 
    {
        System.out.println("in B");
    }
}

class C extends B 
{
    public void show() 
    {
        System.out.println("in C");
    }
}

public class Polymorphisam {
    public static void main(String[] args) {
        A obj = new A();
        obj.show();

        obj = new B();
        obj.show();

        obj = new C();
        obj.show();
    }
}

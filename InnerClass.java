abstract class A {
    int a;

    abstract public void show();

    static class B {
        public void config() {
            System.out.println("in config B mehtods");
        }
    }
}

public class InnerClass {
    public static void main(String[] args) {
        A obj = new A()
        {
            //anonymus abstract class
            public void show() 
            {
                System.out.println("In new show");
            }
        };
        obj.show();

        // A.B obj1 = obj.new B(); when we have non-static method
        A.B obj1 = new A.B();
        obj1.config();
    }
}

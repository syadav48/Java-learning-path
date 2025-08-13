class A 
{
    public void show1()
    {
        System.out.println("in A show");
    }
}

class B extends A 
{
     public void show2()
    {
        System.out.println("in B show");
    }
}

class ObjCasting {
    public static void main(String[] args) {
        A obj = (A) new B();
        obj.show1();

        B obj1 = (B) obj;
        obj1.show1();
        obj1.show2();
    }
}

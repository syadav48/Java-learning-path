class A 
{
    public void shouldBelongstothisClass()
    {
        System.out.println("In A class");
    }
}
class B extends A 
{  
    @Override
    public void shouldBelongstothisClass()
    {
        System.out.println(" in B Class");
    }
}

public class Annota {
    public static void main(String[] args) {
        A obj = new B();
        obj.shouldBelongstothisClass();
    }    
}

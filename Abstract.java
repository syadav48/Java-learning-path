
abstract class Car 
{
    public abstract void drive();
    public abstract  void fly();

    public void playmusic() 
    {
        System.out.println("playing music...");
    }

}

abstract class WagonaR extends Car 
{
    public void drive()
    {
        System.out.println("driving");
    }
}

class UpdatedWagonaR extends WagonaR  // concrete method
{ 
      public void fly()
    {
        System.out.println("flying");
    }
}


public class Abstract {
    public static void main(String[] args) {
        Car obj = new UpdatedWagonaR();
        obj.drive();
        obj.fly();
        obj.playmusic(); 
        
        
    }
}

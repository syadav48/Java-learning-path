// final class - stop inthertence
// final method - stop overriding
// final variabl - make the varaible constant
// final 
class Calc 
{
    
    final public void show()
    {
        System.out.println("by Surya");
    }
    public int add(int a, int b)
    {
        return a + b;
    }
}

class AdvCalc extends Calc 
{
    // public void show() 
    // {

    // }
}

public class Final {
    public static void main(String[] args) {
        AdvCal obj = new AdvCal();
        obj.show();
        obj.add(4, 5 );
    }
}

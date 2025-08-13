// class - class -> extends
// class - interface -> implements
// interface - interface -> extends

interface Computer 
{
     void code();
    
}

class Laptop implements Computer
{
    public void code()
    {
        System.out.println("code, compile, run");
    }
}
class Desktop implements Computer 
{
    public void code()
    {
        System.out.println("code, compile, run, faster..");
    }
}

class Developer
{
    public void devApp(Computer lap) 
    {
        lap.code();
    }
}

interface A 
{
    // variables are final and static
    int age = 44;
    String area = "Kolkata";
    // by default these methods are public abstract
    void show();
    void config();
}

interface X 
{
    void run();
}

interface Y extends X 
{

}

class B implements A, Y
{

    public void config() {
        System.out.println("in config");        
    }

    @Override
    public void show() {
        System.out.println("in show");        
    }
    public void run() {
        System.out.println("running...");
    }

}


public class Interfacea {
    public static void main(String[] args) {
        A obj = new B();
        obj.show();
        obj.config();

        X obj1 = new B();
        obj1.run();
        System.out.println(A.area);

        Computer lap = new Laptop();
        Computer desk = new Desktop();
        Developer surya = new Developer();
        surya.devApp(lap);
        
    }
}

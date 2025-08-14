enum Status {
    Running, Pending, Success, Failed;
}

enum Laptop 
{
    Macbook(2000), XPS(2200), Surface, ThinkPad(1800);

    private int price;
    private Laptop()
    {
        price = 500;
        System.out.println("in Laptop1");
    }
    private Laptop(int price)
    {
        this.price = price;
        System.out.println("in Laptop2");
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}

public class Enuma {
    public static void main(String[] args) {
        Status s = Status.Pending;
        Status[] all = Status.values();
        for (Status st : all) {
            System.out.println(st + " " + st.ordinal());
        }
        System.out.println(s + " " + s.ordinal());

        if (s == Status.Running)
            System.out.println("All Good");
        else if (s == Status.Pending)
            System.out.println("Please wait");
        else if (s == Status.Failed)
            System.out.println("Try Again");
        else
            System.out.println("Done");

        switch (s) {
            case Running:
                System.out.println("All Good");
                break;
            case Pending:
                System.out.println("Please wait");
                break;
            case Failed:
                System.out.println("Try Again");
                break;
            case Success:
                System.out.println("Done");
            default:
                break;
        }
        for(Laptop lap : Laptop.values())
        {
            System.out.println(lap + " : " + lap.getPrice());
        }

    }
}

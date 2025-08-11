 class Mobile {
    String brand;
    int price; 
    //instance variable
    static String name;

    public void show()
    {
        System.out.println(brand + " : " + price + " : " + name);
    }
    static 
    {
        name = "Phone";
        System.out.println("in static block");
    }// static block

    public static void show1(Mobile obj)
    {
        System.out.println(obj.brand + " : " + obj.price + " : " + name);
    } //static method

}


public class Statica {
    public static void main(String[] args) {
        Mobile obj1 = new Mobile();
        Mobile obj2 = new Mobile();
        obj1.brand = "Apple";
        obj1.price = 100;
        Mobile.name = "Phone";

        obj2.brand = "Samsung";
        obj2.price = 200;
        Mobile.name = "Phone";

        obj1.show();
        obj2.show();

        Mobile.show1(obj2);
        
    }
}

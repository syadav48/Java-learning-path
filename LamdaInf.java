@FunctionalInterface // is a interface which only have one method, not support multiple methods
interface A 
{
    //void show(int a);
     int add(int a, int b);
}
public class LamdaInf {
    public static void main(String[] args) 
    {
        // A obj = new A()
        // {
        //     public void show()
        //     {
        //         System.out.println("in a show");
        //     }
        // };
        // A obj = i -> System.out.println("Lamda" + " " + i); // replaced anonymus class
        // obj.show(5);
        A obj = (i , j) -> i + j;
        int res =  obj.add(5, 6);
        System.out.println(res);
    }
}

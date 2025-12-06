package Interview.javaCore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Car{
    Car(){
        System.out.println("in Car");
    }
}
class Truck implements Cloneable{
    int speed = 100;
    public Object clone() throws CloneNotSupportedException{
       return super.clone();
    }
}
//class Zeep implements Serializable throws FileNotFoundException{
//    int speed = 100;
//}
public class Q3_ObjectCreation {
    public  boolean objectCreation(){
        return true;
    }
    public static void main(String[] args) throws CloneNotSupportedException, FileNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //using new keyword:
        Q3_ObjectCreation q3ObjectCreation = new Q3_ObjectCreation();
        System.out.println(q3ObjectCreation.objectCreation());
        Car car = new Car();
        System.out.println(car);


        //using clone:
        Truck truck = new Truck();
        Truck clone = (Truck) truck.clone();
        System.out.println(clone.speed);

        //using deserialization
//        ObjectInputStream in = new ObjectInputStream(new FileInputStream("zeep.ser"));
//        Zeep zeep = (Zeep) in.readObject();
//        System.out.println(zeep.speed);

        //using reflection
        Constructor<Car> cons = Car.class.getDeclaredConstructor();
        Car car1 = cons.newInstance();
        System.out.println(car1);


    }
}

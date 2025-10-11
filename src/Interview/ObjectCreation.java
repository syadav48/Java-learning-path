package Interview;

public class ObjectCreation {
    static class Car{
        Car(){
            System.out.println("Car constructor called");
        }
    }

    static void main(String[] args) {
        Car car = new Car();
        System.out.println(car);
    }
}

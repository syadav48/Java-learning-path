package LLD.designPattern.creational.singleton;

public class Singleton {
    public static void main(String[] args) {
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println(instance1 + " " + instance2);
    }
}

package Multithreading;

public class Test {
    public static void main(String[] args) {
//        World world = new World();
//        world.start();
       AnotherWorld anotherWorld = new AnotherWorld();
       Thread t1 = new Thread(anotherWorld);
        t1.start();
        for (; ;) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

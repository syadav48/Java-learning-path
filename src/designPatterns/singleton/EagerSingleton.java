package designPatterns.singleton;

public class EagerSingleton {
    private static final EagerSingleton eagerSingleTon = new EagerSingleton();
    private EagerSingleton(){

    }
    // but here the problem is if no instance is required, JVM will still create has the one instances with it. then soln is  -> Multithreaded Singleton
    public static EagerSingleton getInstance(){
        return eagerSingleTon;
    }
}

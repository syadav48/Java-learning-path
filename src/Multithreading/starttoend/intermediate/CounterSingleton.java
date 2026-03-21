package Multithreading.starttoend.intermediate;

public class CounterSingleton {
    private static volatile CounterSingleton instance;
    private int count = 0;
    private CounterSingleton(){

    }
    public static CounterSingleton getInstance(){
        if(instance == null){
            synchronized (CounterSingleton.class){
                if(instance == null){
                    instance = new CounterSingleton();
                }
            }
        }
        return instance;
    }
    public synchronized void increment(){
        count++;
    }
    public synchronized int getCount(){
        return count;
    }
}

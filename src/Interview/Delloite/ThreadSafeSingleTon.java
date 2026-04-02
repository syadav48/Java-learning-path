package Interview.Delloite;

import LLD.designPattern.creational.singleton.Singleton;

public class ThreadSafeSingleTon {
    private int num;
    private String name;
    private static volatile ThreadSafeSingleTon instance;

    private ThreadSafeSingleTon(int num, String name) {
       this.num = num;
       this.name = name;
    }
    public static ThreadSafeSingleTon getInstance(int num, String name){
        if(instance == null){
            synchronized (ThreadSafeSingleTon.class){
                if(instance == null){
                    instance = new ThreadSafeSingleTon(num, name);
                }
            }
        }
        return instance;
    };

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
}

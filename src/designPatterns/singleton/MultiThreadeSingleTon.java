package designPatterns.singleton;

public class MultiThreadeSingleTon {
    private static MultiThreadeSingleTon instance = null;
    private MultiThreadeSingleTon(){

    }
    public static MultiThreadeSingleTon getInstance(){
        if(instance == null){
            synchronized (MultiThreadeSingleTon.class){
                if(instance == null){
                    instance = new MultiThreadeSingleTon();
                }
            }
        }
        return instance;
    }
}

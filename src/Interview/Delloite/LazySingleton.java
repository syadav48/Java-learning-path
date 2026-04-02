package Interview.Delloite;

public class LazySingleton {
    private int num;
    private String name;
    private LazySingleton(){

    };
    private static class Holder{
        private static final LazySingleton INSTANCE = new LazySingleton();
    }
    public static LazySingleton getInstance(){
        return Holder.INSTANCE;
    }

}

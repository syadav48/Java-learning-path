package Interview.Delloite;

public class Singleton {
    private int num;
    private String name;
    private static Singleton instance;

     private Singleton(int num, String name){
        this.num = num;
        this.name = name;
    }
    public static Singleton getInstance(int num, String name){
        if(instance == null){
            instance = new Singleton(num, name);
        }
        return instance;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
}

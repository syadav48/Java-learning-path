package Interview.outputbasedjava.string;

public class StaticExecution {
    static int x = Inint();
    static {
        System.out.println("static block execution");
    }
    private static int Inint(){
        System.out.println("Static variable initialization");
        return 5;
    }
    public static void main(String[] args) {
        System.out.println("main block");
    }
}

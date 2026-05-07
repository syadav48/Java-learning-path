package LTMClinet.core.easy;

public class CheckingConstructor {
    static {
        System.out.printf("On the top");
    }
    {
        System.out.println("\n On the middle");
    }
    CheckingConstructor(){
        System.out.println("In the lower");
    }
   public static void main(String[] args) {
       CheckingConstructor check1 = new CheckingConstructor();
       CheckingConstructor check2 = new CheckingConstructor();

    }
}

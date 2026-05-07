package LTMClinet.core.oneToHundred;

class Test1{
    int num;
    Test1(){
        this(10);
        System.out.println("Default One");
    }
    Test1(int num){
        System.out.println("Parametrized One:"+ num);
    }
}
public class RecursiveConstructor {

    public static void main(String[] args) {
        new Test1();
    }
}

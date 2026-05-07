package LTMClinet.core.oneToHundred;

import java.lang.reflect.Array;
import java.util.Arrays;

class X{
    final int x;

     X(int x) {
        this.x = x;
    }
    int point(int... x){
        int sum = 0;
        for(int i : x) sum += i;
        return sum;

    }


    final void check(){
        //no overriding possible
        System.out.println("checking");
    }
}

class Y extends X{
    private int n;
    static {
        System.out.println("CompileTime binding");
    }
    Y(int x, int n) {
        super(x);
        this.n = n;
    }
      private void show(){
        // it cant be inherited -> no run time polymorphisam
        System.out.println("Showing");
    }

}
// final, static and private are compile time binding
public class RunCompileBinding {

    public static void main(String[] args) {
        Y y = new Y(10, 20);
        X x = new X(40);
        System.out.println(x.point(new  int []{1,2,3}));

    }
}

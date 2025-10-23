package generics;

import java.io.Serializable;

public class Counter <T extends  Number & Serializable> { // here we bound the T only number class can be operated
    T t;
    Counter(T t){
        this.t = t;
    }
    public void print(){
        System.out.println(t);
    }
}

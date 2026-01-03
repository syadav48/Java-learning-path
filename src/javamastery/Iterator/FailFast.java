package javamastery.Iterator;

import java.util.concurrent.CopyOnWriteArrayList;

public class FailFast {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> copy = new CopyOnWriteArrayList<>();
        copy.add(1);
        copy.add(2);
        copy.add(3);
        for (Integer i: copy){
            copy.add(4);
        }
        System.out.println(copy);
    }
}

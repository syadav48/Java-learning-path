package designPatterns.singleton;

import Interview.Delloite.Singleton;

import java.io.Serializable;

public class LazySingleton implements Serializable {
    private static LazySingleton lazySingleton = null;

    private LazySingleton(){

    }

    public static LazySingleton getLazySingleton() {
        // In case of Multithreading if two threads accessing it, it can create two objects: Hence EagerSingleton
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}

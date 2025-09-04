package collections.practice;

import java.util.HashSet;

public class HashCreate {
    public static void main(String[] args) {
        HashSet<String> hash = new HashSet<>();
        hash.add("Ram");
        hash.add("Shyam");
        hash.add("Sandeep");
        hash.add("Sunil");
        hash.add("Ram");
        System.out.println(hash);
    }
}

package Interview.javaCore;

import java.util.ArrayList;
import java.util.List;

class Person {
    private final String name;
    private final List<String> hobbies;

    public Person(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = new ArrayList<>(hobbies);  // ✔ Copy on assignment
    }

    public List<String> getHobbies() {
        return new ArrayList<>(hobbies);          // ✔ Copy on return
    }
}


final class ImmutableObject{
    private final String immutable;
    ImmutableObject(String immutable){
        this.immutable = immutable;
    }

    public String getImmutable() {
        return immutable;
    }
}
public class Q13_ImmutableObject {
    public static void main(String[] args) {
        String str = "Immutable";
        ImmutableObject immutableObject = new ImmutableObject(str);
        System.out.println(immutableObject.getImmutable());

        List<String> list = new ArrayList<>();
        list.add("Cricket");

//        Person3 p = new Person3("John", list);
//        p.getHobbies().add("Hacking");
//
//        System.out.println(p.getHobbies());

    }
}

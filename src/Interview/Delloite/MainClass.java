package Interview.Delloite;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) {
        ImmutableClass immutableClass = new ImmutableClass("1", "Satish", List.of("Admin"));
//        immutableClass.getRoles().add("Architect");
        System.out.println(immutableClass);
        System.out.println(Collections.emptyList());

        CustomClass key1 = new CustomClass(1, "A");
        CustomClass key2 = new CustomClass(2, "B");
        Map<CustomClass, String> map = new HashMap<>();
        map.put(key1, "V1");
        map.put(key2, "V3");

        List<Integer> list = map.keySet().stream().map(x -> x.hashCode()).toList();
        System.out.println(list);

        Singleton singleton = Singleton.getInstance(1, "Sam");
        Singleton singleton2 = Singleton.getInstance(3, "Sham");
        System.out.println(singleton.getName());
        System.out.println(singleton2.getName());
        ThreadSafeSingleTon threadSafeSingleTon = ThreadSafeSingleTon.getInstance(101, "Ram");
        ThreadSafeSingleTon threadSafeSingleTon2 = ThreadSafeSingleTon.getInstance(121, "Rham");

        System.out.println(threadSafeSingleTon.getName());
        System.out.println(threadSafeSingleTon2.getName());

        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();

        System.out.println(lazySingleton1 == lazySingleton2);
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
        System.out.println(enumSingleton1);
        System.out.println(enumSingleton2);
        System.out.println(enumSingleton2 == enumSingleton1);

        User user = new User.Builder().setId(1).setName("Sangita").build();
        System.out.println(user.hashCode());


    }
}

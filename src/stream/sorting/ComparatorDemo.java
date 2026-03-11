package stream.sorting;

import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

 class Students{
    String name;
    int age;

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return name + " age: " + age;
    }
}


public class ComparatorDemo {
    public static void main(String[] args) {
        List<Students> list = Arrays.asList(
                new Students("Surya", 21),
                new Students("Rahul", 23),
                new Students("Viki", 24)
        );
        Comparator<Students> nameSort = (s1, s2) -> s1.name.compareTo(s2.name);
        Collections.sort(list, nameSort);
        System.out.println(list);
        Comparator<Students> ageSortDesc = (s1, s2) -> s2.age - s1.age;

        Collections.sort(list, nameSort);
        System.out.println("By Name: " + list);

        Collections.sort(list, ageSortDesc);
        System.out.println("By Age Desc: " + list);
    }
}

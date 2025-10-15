package javamastery.stream.Intermediate;

import java.util.*;
import java.util.stream.Collectors;

public class Q8_groupToSet {
    public static void toSetMap(List<Person> list){
       Set<String> set = list.stream().map(x -> x.name).collect(Collectors.toSet());
       Map<String, String> map = list.stream().collect(Collectors.toMap(Person::getName, Person::getName));
        System.out.println(set);
        System.out.println(map);
    }
    public static void main(String[] args) {
        Person person1 = new Person("Suresh");
        Person person2 = new Person("Mahesh");
        Person person3 = new Person("Ramesh");
        Person person4 = new Person("Rakesh");
        Person person5 = new Person("Rajesh");

        List<Person> list = Arrays.asList(person1, person2, person3, person4, person5);
        toSetMap(list);
    }
}

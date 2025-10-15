package stream.collectors;

import java.util.List;

public class Person {
    private String name;
    private int age;
    private String gender;
    private List<String> hobbies;

    public Person(String name, int age, String gender, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobbies = hobbies;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public List<String> getHobbies() { return hobbies; }

    @Override
    public String toString() {
        return name + " (" + gender + ", " + age + ")";
    }
}

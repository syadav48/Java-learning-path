class Human {
    private int age;
    private String name;

    public Human() // defualt constructor 
    {
        System.out.println("in the const");
        age = 12;
        name= "Surya";
    }

    public Human(String name) {
        this.age = 12;
        this.name = name;
    }

    public Human(int age, String name) { // parametrized constructor
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        // this refers to the current object which is calling the setage
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        // this refers to the current object which is calling the setage
        this.name = name;
    }
    
}

public class Const {
    public static void main(String[] args) {
        Human obj1 = new Human();
        Human obj2 = new Human();
        System.out.println(obj1.getName() + obj2.getAge());

    }
}

 class Human {
    private int age;
    private String name;

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


public class Thisa {
    public static void main(String[] args) {
        Human obj = new Human();
        obj.setAge(30);
        obj.setName("Suryoday");
        System.out.println(obj.getName() + "age:" + obj.getAge());
    }
}

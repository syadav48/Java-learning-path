 class Human {
    private int age = 15;
    private String name = "Suryoday";

    public int getAge()
    {
        return age;
    }
     public void setAge(int a)
    {   
        age = a;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String nm)
    {
         name = nm;
    }
    
}

public class Encaps {
    public static void main(String[] args) {
        Human obj = new Human();
        obj.setAge(14);
        obj.setName("Sangita");
        System.out.println(obj.getName());
        System.out.println(obj.getAge());
    }
}

package Interview.javaCore;

class House{
    private String house;
    House(){
        System.out.println("house in making");
    }

    public String getHouse() {
        return house;
    }
}
class Home extends House{
    Home(){
//        super(); this one called automatically
        System.out.println("home in making");
    }
    void showHouse(){
        System.out.println(getHouse());

    }
}


public class Q7_InheritanceQns {
    public static void main(String[] args) {
        House house = new House();
        System.out.println(house.getHouse());
    }
}

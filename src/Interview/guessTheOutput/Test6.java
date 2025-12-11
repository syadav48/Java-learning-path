package Interview.guessTheOutput;

class BA {
    void display() { System.out.println("A display"); }
}
class CB extends BA {
    void display() {
        super.display();
        System.out.println("B display");
    }
}
class CD extends CB {
    void display() {
        System.out.println("C display");
        super.display();
    }
}
public class Test6 {
    public static void main(String[] args) {
        new CD().display();
        //C display
        // A display
        // B display
    }
}

package Interview.guessTheOutput;

class ABC {
    void show() {
        System.out.println("A show");
    }
}

class BC extends ABC {
    void show() {
        System.out.println("B show");
        super.show();
    }
}
public class Test5 {
    public static void main(String[] args) {
        new BC().show();
        //B show
        //A show
    }
}

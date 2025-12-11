package Interview.guessTheOutput;


class AV {
    int x = 10;
}

class BV extends AV {
    int x = 20;
    void show() {
        System.out.println(x);
        System.out.println(super.x);
    }
}
public class Test7 {
    public static void main(String[] args) {
        new BV().show();
        // 20
        // 10
    }
}

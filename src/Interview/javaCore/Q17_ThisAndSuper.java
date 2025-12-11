package Interview.javaCore;


class ThisExample {
    void doSomething() {
       AnotherThisExample anotherThisExample = new AnotherThisExample();
       anotherThisExample.process(this);
    }
}
class AnotherThisExample{
    void process(ThisExample obj) {
        System.out.println("Object received from A");
    }
}
public class Q17_ThisAndSuper {
    public static void main(String[] args) {

    }
}

package Interview.guessTheOutput;

interface IA{
    void show();
}

class IB implements IA{
    public void show(){
        System.out.println("method1");
    }
}
class IC extends IB{
    public void show() {
        System.out.println("C show");
    }
}

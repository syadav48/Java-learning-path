package Interview.javaCore.interfaceExample;

interface X {
    int x = 10;
}

interface Y {
    int x = 20;  // what happens here?
}

public class Z implements X, Y {
    void printX() {
        System.out.println(X.x);
        // 10
    }
}


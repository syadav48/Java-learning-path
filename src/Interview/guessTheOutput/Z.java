package Interview.guessTheOutput;

interface X {
    int value = 10;
}

interface Y {
    int value = 20;
}

class Z implements X, Y {
    void print() {
       // System.out.println(value);
    }
}

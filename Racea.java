class  Counter {
    int count;
    public synchronized void increment() {
        count++;
    }
}

public class Racea {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Runnable obj1 = () -> {
            for (int i = 0; i < 5000; i++) {
                c.increment();
            }
        };
        Runnable obj2 = () -> {
            for (int i = 0; i < 5000; i++) {
                c.increment();
            }
        };
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        // obj1.start();
        t1.start();
        t2.start();
        // let them comeback, after 1000s iteration, whatever the value they have print that only
        t1.join();
        t2.join();
        // we will not get 10,000 everytime, mostly i'd say
        // reason- it may happen, count variable goes into the both thread at the same time but got incremented only once.
        // how to make concistent?
        // sharing varibales in thread is not feasible or not recommended
        // add synchornize in the method, so that if t1 is working on the variable then t2 has to wait
        // now you will get 10000, so we saved ourselves from race condition
        
        System.out.println(c.count);
    }
}

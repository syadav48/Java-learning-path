package Multithreading.starttoend.intermediate;

public class Q1_SingletonTest {
    public static void main(String[] args) throws InterruptedException {
        CounterSingleton counter = CounterSingleton.getInstance();
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        });
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        });
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();

        System.out.println("Final count: " + counter.getCount());
    }
}

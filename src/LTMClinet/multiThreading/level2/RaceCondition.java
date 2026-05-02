package LTMClinet.multiThreading.level2;
class Counter{
    private int count = 0;

    public Counter(int count) {
        this.count = count;
    }
    public synchronized void incrementCounter(){
        count++;
    }

    public int getCount() {
        return count;
    }
}
public class RaceCondition {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(0);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.incrementCounter();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.incrementCounter();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter.getCount());

    }

}

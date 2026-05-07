package Multithreading.LTM.basics;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PriorityTask implements Runnable, Comparable<PriorityTask>{
    private final int priority;
    private final String name;

    public int getPriority() {
        return priority;
    }

    public PriorityTask(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(PriorityTask o) {
        return Integer.compare(o.priority, this.priority);
    }

    @Override
    public void run() {
        System.out.println(
                "Executing " + name + " with priority " + priority
        );

    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                1,
                0L,
                TimeUnit.MILLISECONDS,
                new PriorityBlockingQueue<>()
        );
        executor.execute(new PriorityTask(10, "High"));
        executor.execute(new PriorityTask(1, "Low"));
        executor.execute(new PriorityTask(5, "Medium"));
        executor.shutdown();

    }
}

package Multithreading.executorFramework;

import java.util.concurrent.CountDownLatch;

public class CountDownAppInitialization {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Thread databaseService = new Thread(new Service("Database Service", 3000, latch));
        Thread cacheService = new Thread(new Service("Cache Service", 2000, latch));
        Thread logService = new Thread(new Service("Logging Service", 4000, latch));

        databaseService.start();
        cacheService.start();
        logService.start();

        System.out.println("Main thread waiting for all services to initialize...");
        latch.await();
        System.out.println("All services are up. Application is ready to start!");
    }
}

class Service implements Runnable {
    private final String name;
    private final int delay;
    private final CountDownLatch latch;

    public Service(String name, int delay, CountDownLatch latch) {
        this.name = name;
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            System.out.println(name + " is Up!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown(); // count down no matter what
        }
    }
}


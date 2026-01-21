package ProjectWiseLearning.multiThreading.concurrentOrders.util;

import ProjectWiseLearning.multiThreading.concurrentOrders.model.Order;

public class OrderQueue {

    private Order order;
    private boolean hasOrder = false;

    public synchronized void placeOrder(Order newOrder) throws InterruptedException {
        while (hasOrder) wait();
        this.order = newOrder;
        hasOrder = true;
        notify();
    }

    public synchronized Order consumeOrder() throws InterruptedException {
        while (!hasOrder) wait();
        hasOrder = false;
        notify();
        return order;
    }
}


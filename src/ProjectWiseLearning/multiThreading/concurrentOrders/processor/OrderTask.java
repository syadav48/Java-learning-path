package ProjectWiseLearning.multiThreading.concurrentOrders.processor;

import ProjectWiseLearning.multiThreading.concurrentOrders.inventory.Inventory;
import ProjectWiseLearning.multiThreading.concurrentOrders.model.Order;
import ProjectWiseLearning.multiThreading.concurrentOrders.util.OrderQueue;

public class OrderTask implements Runnable {

    private final OrderQueue queue;
    private final Inventory inventory;

    public OrderTask(OrderQueue queue, Inventory inventory) {
        this.queue = queue;
        this.inventory = inventory;
    }

    @Override
    public void run() {
        try {
            Order order = queue.consumeOrder();
            inventory.processOrder(order);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}



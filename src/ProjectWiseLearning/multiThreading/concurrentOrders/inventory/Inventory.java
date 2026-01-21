package ProjectWiseLearning.multiThreading.concurrentOrders.inventory;

import ProjectWiseLearning.multiThreading.concurrentOrders.model.Order;

public class Inventory {

    private int stock = 10;

    public synchronized void processOrder(Order order) {
        if (stock >= order.getQuantity()) {
            stock -= order.getQuantity();
            System.out.println(
                    "Order " + order.getOrderId() +
                            " processed. Stock left: " + stock
            );
        }
    }
}



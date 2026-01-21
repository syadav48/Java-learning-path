package ProjectWiseLearning.multiThreading.concurrentOrders.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Order {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1000);

    private final int orderId;
    private final String product;
    private final int quantity;

    public Order(String product, int quantity) {
        this.orderId = ID_GENERATOR.incrementAndGet();
        this.product = product;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}


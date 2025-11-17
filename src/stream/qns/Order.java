package stream.qns;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private final int orderId;
    private final int customerId;
    private final List<Product> products;
    private final LocalDate orderDate;

    public Order(int orderId, int customerId, List<Product> products, LocalDate orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.products = products;
        this.orderDate = orderDate;
    }

    public int getOrderId() { return orderId; }
    public int getCustomerId() { return customerId; }
    public List<Product> getProducts() { return products; }
    public LocalDate getOrderDate() { return orderDate; }
}


package ProjectWiseLearning.multiThreading.concurrentOrders.processor;

import ProjectWiseLearning.multiThreading.concurrentOrders.model.Order;

import java.util.concurrent.Callable;

public class PaymentTask implements Callable<Boolean> {

    private final Order order;

    public PaymentTask(Order order) {
        this.order = order;
    }

    @Override
    public Boolean call() throws Exception {
        Thread.sleep(300); // simulate gateway delay
        System.out.println("Payment completed for Order " + order.getOrderId());
        return true;
    }
}


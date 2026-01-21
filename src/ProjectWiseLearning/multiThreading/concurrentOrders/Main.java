package ProjectWiseLearning.multiThreading.concurrentOrders;

import ProjectWiseLearning.multiThreading.concurrentOrders.inventory.Inventory;
import ProjectWiseLearning.multiThreading.concurrentOrders.model.Order;
import ProjectWiseLearning.multiThreading.concurrentOrders.processor.OrderTask;
import ProjectWiseLearning.multiThreading.concurrentOrders.processor.PaymentTask;
import ProjectWiseLearning.multiThreading.concurrentOrders.util.OrderQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {

        OrderQueue queue = new OrderQueue();
        Inventory inventory = new Inventory();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Order order = new Order("Laptop", 4);
        queue.placeOrder(order);
        executor.submit(new OrderTask(queue, inventory));
        Future<Boolean> payment =
                executor.submit(new PaymentTask(order));

        payment.get(); // wait for result
        executor.shutdown();
    }
}


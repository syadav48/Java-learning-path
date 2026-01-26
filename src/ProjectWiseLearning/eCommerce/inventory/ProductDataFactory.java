package ProjectWiseLearning.eCommerce.inventory;

import java.util.List;

public class ProductDataFactory {
    public static List<Product> getProducts(){
        return List.of(
                create(1, "Laptop", "ELECTRONICS", 75000, 10, false),
                create(2, "Smartphone", "ELECTRONICS", 45000, 25, false),
                create(3, "Headphones", "ELECTRONICS", 3000, 50, false),

                create(4, "Rice Bag", "GROCERY", 1200, 100, true),
                create(5, "Milk Packet", "GROCERY", 60, 200, true),
                create(6, "Olive Oil", "GROCERY", 900, 40, true),

                create(7, "T-Shirt", "CLOTHING", 800, 60, false),
                create(8, "Jeans", "CLOTHING", 2200, 30, false),
                create(9, "Jacket", "CLOTHING", 4500, 15, false),
                create(10, "Office Chair", "FURNITURE", 6500, 12, false),
                create(11, "Dining Table", "FURNITURE", 25000, 5, false),
                create(12, "Bookshelf", "FURNITURE", 8000, 8, false),

                create(13, "Water Bottle", "GROCERY", 40, 300, false),
                create(14, "LED Bulb", "ELECTRONICS", 350, 100, false),
                create(15, "Mixer Grinder", "ELECTRONICS", 6000, 20, false),

                create(16, "Shoes", "CLOTHING", 3200, 25, false),
                create(17, "Sofa Set", "FURNITURE", 55000, 3, false),
                create(18, "Notebook", "GROCERY", 70, 150, false),
                create(19, "Washing Machine", "ELECTRONICS", 28000, 7, false),
                create(20, "Curtains", "FURNITURE", 3000, 18, false)
                );
    }

    private static Product create(int i, String name, String category, int price, int quantity, boolean perishable) {
            Product p = new Product();
            p.id = i;
            p.name = name;
            p.category = category;
            p.price = price;
            p.quantity = quantity;
            p.perishable = perishable;
            return p;
    };


}

package ProjectWiseLearning.eCommerce.user;

import java.util.List;

class UserDataFactory {

    public static List<User> getUsers() {
        return List.of(
                create(1, "Amit Sharma", "amit@gmail.com", "CUSTOMER", true, "India"),
                create(2, "Neha Verma", "neha@gmail.com", "CUSTOMER", true, "India"),
                create(3, "Rahul Singh", "rahul@gmail.com", "CUSTOMER", true, "India"),
                create(4, "Pooja Mehta", "pooja@gmail.com", "CUSTOMER", false, "India"),
                create(5, "Karan Malhotra", "karan@gmail.com", "CUSTOMER", true, "India"),

                create(6, "John Miller", "john@gmail.com", "CUSTOMER", true, "USA"),
                create(7, "Emily Clark", "emily@gmail.com", "CUSTOMER", true, "USA"),
                create(8, "David Wilson", "david@gmail.com", "CUSTOMER", false, "USA"),

                create(9, "Ravi Kumar", "ravi@gmail.com", "SELLER", true, "India"),
                create(10, "Sneha Patel", "sneha@gmail.com", "SELLER", true, "India"),

                create(11, "Admin One", "admin1@sys.com", "ADMIN", true, "India"),
                create(12, "Admin Two", "admin2@sys.com", "ADMIN", true, "USA"),

                create(13, "Arjun Nair", "arjun@gmail.com", "CUSTOMER", true, "India"),
                create(14, "Meera Iyer", "meera@gmail.com", "CUSTOMER", true, "India"),
                create(15, "Rohit Jain", "rohit@gmail.com", "CUSTOMER", false, "India"),

                create(16, "Sophia Brown", "sophia@gmail.com", "CUSTOMER", true, "UK"),
                create(17, "Liam Johnson", "liam@gmail.com", "CUSTOMER", true, "UK"),

                create(18, "Vendor A", "vendorA@shop.com", "SELLER", true, "India"),
                create(19, "Vendor B", "vendorB@shop.com", "SELLER", false, "India"),

                create(20, "System Bot", "system@sys.com", "ADMIN", true, "GLOBAL")
        );
    }

    private static User create(int id, String name, String email,
                               String role, boolean active, String country) {
        User u = new User();
        u.id = id;
        u.name = name;
        u.email = email;
        u.role = role;
        u.active = active;
        u.country = country;
        return u;
    }
}


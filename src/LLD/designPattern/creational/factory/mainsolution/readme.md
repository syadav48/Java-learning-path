Product (e.g., Notification): An interface or abstract class for the objects the factory method creates.
ConcreteProduct (e.g., EmailNotification, SMSNotification): Concrete classes that implement the Product interface.
Creator (e.g., NotificationCreator): An abstract class (or an interface) that declares the factory method, which returns an object of type Product. It might also define a default implementation of the factory method. The Creator can also have other methods that use the product created by the factory method.
ConcreteCreator (e.g., EmailNotificationCreator, SMSNotificationCreator): Subclasses that override the factory method to return an instance of a specific ConcreteProduct.

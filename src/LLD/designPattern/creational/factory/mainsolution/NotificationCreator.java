package LLD.designPattern.creational.factory.mainsolution;

abstract class NotificationCreator {
    public abstract Notification createNotification();
    public void send(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}

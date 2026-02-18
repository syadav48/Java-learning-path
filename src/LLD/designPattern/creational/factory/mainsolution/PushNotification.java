package LLD.designPattern.creational.factory.mainsolution;

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending push notification: " + message);
    }
}

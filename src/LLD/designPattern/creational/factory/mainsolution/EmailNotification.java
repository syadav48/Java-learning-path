package LLD.designPattern.creational.factory.mainsolution;

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

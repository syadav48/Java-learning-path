package LLD.designPattern.creational.factory.problem;

class NotificationService {
    public void sendNotification(String type, String message) {
        if (type.equals("EMAIL")) {
            EmailNotification email = new EmailNotification();
            email.send(message);
        } else if (type.equals("SMS")) {
            SMSNotification sms = new SMSNotification();
            sms.send(message);
        } else if (type.equals("Push")) {
            PushNotification sms = new PushNotification();
        }
        // what if a new requirement for slack or whatsapp, telegram ??
    }

    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification("SMS", "hey get 1000 rs after paying only 5000");
    }
}

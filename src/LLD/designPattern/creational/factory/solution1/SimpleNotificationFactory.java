package LLD.designPattern.creational.factory.solution1;

import LLD.designPattern.creational.factory.problem.EmailNotification;
import LLD.designPattern.creational.factory.problem.PushNotification;
import LLD.designPattern.creational.factory.problem.SMSNotification;

import javax.management.Notification;

class SimpleNotificationFactory {
  //  public static Notification createNotification(String type) {
//        return switch (type) {
//            case "EMAIL" -> new EmailNotification();
//            case "SMS" -> new SMSNotification();
//            case "PUSH" -> new PushNotification();
//            default -> throw new IllegalArgumentException("Unknown type");
//        };

  //  }
}

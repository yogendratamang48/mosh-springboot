package com.ytamang;

public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

package com.ytamang;

public class SMSNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}


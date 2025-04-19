package com.ytamang.ex2_userregistration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {
    @Value("${mail.host}")
    private String host;
    @Value("${mail.port}")
    private String port;

    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("Host: " + host + " Port: " + port);
        System.out.println("Sending email notification: " + message + " to " + recipientEmail);
    }
}

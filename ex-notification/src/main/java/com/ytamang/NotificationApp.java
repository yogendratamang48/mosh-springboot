package com.ytamang;

import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class NotificationApp {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(NotificationApp.class, args);
        var notificationManager = context.getBean(NotificationManager.class);
        notificationManager.sendNotification("Hello, world!");
    }
}

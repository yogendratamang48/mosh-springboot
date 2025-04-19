package com.ytamang.ex1_notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ex1NotificationApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Ex1NotificationApplication.class, args);
		var notificationManager = context.getBean(NotificationManager.class);
		notificationManager.sendNotification("Hello, world!");
	}

}

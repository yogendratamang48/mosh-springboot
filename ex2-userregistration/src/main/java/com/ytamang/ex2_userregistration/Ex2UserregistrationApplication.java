package com.ytamang.ex2_userregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ex2UserregistrationApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Ex2UserregistrationApplication.class, args);
		var userService = context.getBean(UserService.class);
		userService.registerUser(new User(1L, "test@example.com", "password", "John Doe"));
		userService.registerUser(new User(2L, "test2@example.com", "password", "Krykpi Toto"));
		userService.registerUser(new User(3L, "test2@example.com", "password", "Krykpi Toto"));
	}

}

package com.ytamang.store;
// import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ytamang.store.entities.User;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
		var user = new User(1L, "John", "john@gmail.com", "123456");
		System.out.println(user);
		
		var anotherUser = User.builder()
		    .id(2L)
			.name("Yogendra")
			.email("yt@gmail.com")
			.password("123456")
			.build();
		System.out.println(anotherUser);
		
	}

}

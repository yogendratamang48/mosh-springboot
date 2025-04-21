package com.ytamang.store;
// import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ytamang.store.entities.Address;
import com.ytamang.store.entities.Tag;
import com.ytamang.store.entities.User;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
		
		var user = User.builder()
		    .id(2L)
			.name("Yogendra")
			.email("yt@gmail.com")
			.password("123456")
			.build();

		user.addTag("tag1");
		System.out.println(user);
		
	}

}

package com.ytamang.store;
// import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ytamang.store.entities.Address;
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

		var address = Address.builder()
		    .id(1L)
			.street("123 Main St")
			.city("New York")
			.zip("10001")
			.build();
		user.addAddress(address);

		System.out.println(user);
		
	}

}

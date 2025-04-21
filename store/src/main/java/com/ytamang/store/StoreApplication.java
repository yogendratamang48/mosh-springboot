package com.ytamang.store;
// import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ytamang.store.entities.Address;
import com.ytamang.store.entities.Profile;
import com.ytamang.store.entities.Tag;
import com.ytamang.store.entities.User;
import com.ytamang.store.repositories.UserRepository;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		var repository = context.getBean(UserRepository.class);

		var user = User.builder()
			.name("John")
			.email("john@gmail.com")
			.password("123456")
			.build();
		repository.save(user);

		
	}

}

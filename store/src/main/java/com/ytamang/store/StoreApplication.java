package com.ytamang.store;

import com.ytamang.store.services.ProductService;
import com.ytamang.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ytamang.store.repositories.UserRepository;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

//        var service = context.getBean(UserService.class);
//        service.deleteRelated();
        var userService = context.getBean(UserService.class);
//        productService.createProductAndCategory();
//        productService.createProductUnderCategory();
//        productService.addToWishlist();
        userService.fetchProducts();
    }

}

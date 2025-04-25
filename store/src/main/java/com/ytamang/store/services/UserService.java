package com.ytamang.store.services;

import com.ytamang.store.entities.User;
import com.ytamang.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;


    public void showEntityStates(){
        var user = User.builder()
                .name("Yogendra Tamang")
                .email("48yogen@gmail.com")
                .password("password")
                .build();
        if (entityManager.contains(user))
            System.out.println("Entity is persistent");
        else
            System.out.println("Entity is transient/detached");
        System.out.print(user);
        userRepository.save(user);
        if (entityManager.contains(user))
            System.out.println("Entity is persistent");
        else
            System.out.println("Entity is transient/detached");


    }

}

package com.ytamang.store.services;

import com.ytamang.store.entities.User;
import com.ytamang.store.repositories.ProfileRepository;
import com.ytamang.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final EntityManager entityManager;


    @Transactional
    public void showEntityStates() {
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
    @Transactional
    public void showRelatedEntities() {
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getBio());
        System.out.println(profile.getUser().getProfile());
    }

}

package com.ytamang.store.services;

import com.ytamang.store.entities.Address;
import com.ytamang.store.entities.Product;
import com.ytamang.store.entities.Profile;
import com.ytamang.store.entities.User;
import com.ytamang.store.repositories.AddressRepository;
import com.ytamang.store.repositories.ProductRepository;
import com.ytamang.store.repositories.ProfileRepository;
import com.ytamang.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final EntityManager entityManager;
    private final ProductRepository productRepository;

    @Transactional
    public void fetchProducts(){
        var product = new Product();
        product.setName("frying");
        var matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        var example = Example.of(product, matcher);

        var products = productRepository.findAll(example);
        products.forEach(System.out::println);


    }


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

    public void showAddress(){
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getStreet());
    }

    public void persistRelated() {
        var user = User.builder()
                .name("Srijana")
                .email("s@abc.com")
                .password("password123#")
                .build();

        var address = Address.builder()
                .street("Konsul-Schmidt")
                .zip("28205")
                .city("Bremen")
                .state("Bremen")
                .build();
        user.addAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated() {
        var user = userRepository.findById(11L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }


//    @Transactional
    public void fetchUser() {
        var user = userRepository.findByEmail("apple@guru.com").orElseThrow();
        System.out.println(user.getId());
    }

    @Transactional
    public void findProfiles(){
        var profiles = profileRepository.findProfileByLoyaltyPointsGreaterThan(2);
        profiles.forEach((Profile p) -> System.out.println(p.getId()));
        profiles.forEach((Profile p) -> System.out.println(p.getUser().getEmail()));
    }
}
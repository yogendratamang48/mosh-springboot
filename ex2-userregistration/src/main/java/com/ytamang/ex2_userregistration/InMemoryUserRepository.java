package com.ytamang.ex2_userregistration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        // Save user to in-memory storage
        System.out.println("Saving user to in-memory storage: " + user);
        users.put(user.getEmail(), user);
    }

    @Override
    public User findByEmail(String email) {
        // Find user by email in in-memory storage
        System.out.println("Finding user by email in in-memory storage: " + email);
        return users.getOrDefault(email, null);
    }
}

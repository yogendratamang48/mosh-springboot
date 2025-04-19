package com.ytamang.ex2_userregistration;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public UserService(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("User with this email " + user.getEmail() +  " already exists");
        }
        userRepository.save(user);
        notificationService.send("Welcome to our platform!", user.getEmail());
    }
}

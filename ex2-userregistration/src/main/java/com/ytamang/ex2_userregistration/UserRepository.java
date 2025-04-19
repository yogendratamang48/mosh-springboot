package com.ytamang.ex2_userregistration;

public interface UserRepository {
    void save(User user);
    User findByEmail(String email);
}

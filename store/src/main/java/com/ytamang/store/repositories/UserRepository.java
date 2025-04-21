package com.ytamang.store.repositories;

import com.ytamang.store.entities.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    
}

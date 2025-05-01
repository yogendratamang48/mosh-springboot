package com.ytamang.store.repositories;

import com.ytamang.store.entities.User;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
//    @EntityGraph(attributePaths = {"tags"})
    Optional<User> findByEmail(String email);
}

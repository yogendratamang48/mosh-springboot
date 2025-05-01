package com.ytamang.store.repositories;

import com.ytamang.store.entities.Profile;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    @EntityGraph(attributePaths = {"user.email"})
    List<Profile> findProfileByLoyaltyPointsGreaterThan(Integer loyaltyPoints);
}

package com.ytamang.store.repositories;

import com.ytamang.store.entities.Profile;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    List<Profile> findProfileByLoyaltyPointsGreaterThan(Integer loyaltyPointsIsGreaterThan);
}

package com.Logingrupp4.Logingrupp4.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Logingrupp4.Logingrupp4.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}
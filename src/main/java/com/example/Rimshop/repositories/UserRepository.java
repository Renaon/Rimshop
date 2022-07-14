package com.example.Rimshop.repositories;

import com.example.Rimshop.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u where u.login like ?1")
    User loadUserByUsername(String login);


}
package com.example.Rimshop.repositories;

import com.example.Rimshop.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT * FROM users where login:=username")
    public User loadUserByUsername(String username);
}
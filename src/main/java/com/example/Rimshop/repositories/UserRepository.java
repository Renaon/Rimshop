package com.example.Rimshop.repositories;

import com.example.Rimshop.entity.Role;
import com.example.Rimshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.login like ?1")
    User loadUserByUsername(String login);

    @Query("select u from User u where u.login like ?1")
    Optional<User> findByUsername(String username);
}
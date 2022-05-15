package com.asdasd.mjeesh.springsecuritydemo.repository;

import com.asdasd.mjeesh.springsecuritydemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);
}

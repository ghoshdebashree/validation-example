package com.example.validationexample.REPOSITORY;

import com.example.validationexample.ENTITY.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(int id);
}

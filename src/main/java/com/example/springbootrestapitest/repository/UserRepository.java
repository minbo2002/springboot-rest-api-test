package com.example.springbootrestapitest.repository;

import com.example.springbootrestapitest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

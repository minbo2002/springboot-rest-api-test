package com.example.springbootrestapitest.repository.user;

import com.example.springbootrestapitest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String role_admin);
}

package com.project.demo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.demo.security.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

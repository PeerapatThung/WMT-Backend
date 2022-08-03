package com.project.demo.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.project.demo.security.entity.Authority;
import com.project.demo.security.entity.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName input);
}

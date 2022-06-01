package com.project.demo.subject.repository;

import com.project.demo.subject.entity.Category;
import com.project.demo.tutor.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}


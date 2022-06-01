package com.project.demo.review.repository;

import com.project.demo.review.entity.Review;
import com.project.demo.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}

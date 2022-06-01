package com.project.demo.review.service;

import com.project.demo.review.entity.Review;
import com.project.demo.student.entity.Student;
import com.project.demo.tutor.entity.Tutor;

public interface ReviewService {
    Tutor writeReview(Long tutorid, Long studentid, Review review);
}
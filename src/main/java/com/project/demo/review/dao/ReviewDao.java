package com.project.demo.review.dao;

import com.project.demo.review.entity.Review;
import com.project.demo.student.entity.Student;
import com.project.demo.tutor.entity.Tutor;

public interface ReviewDao {
    Tutor writeReview(Tutor tutorid, Student studentid, Review review);
}

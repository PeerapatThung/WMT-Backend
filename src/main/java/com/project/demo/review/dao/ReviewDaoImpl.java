package com.project.demo.review.dao;

import com.project.demo.review.entity.Review;
import com.project.demo.review.repository.ReviewRepository;
import com.project.demo.student.dao.StudentDao;
import com.project.demo.student.entity.Student;
import com.project.demo.student.repository.StudentRepository;
import com.project.demo.tutor.entity.Tutor;
import com.project.demo.tutor.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDaoImpl implements ReviewDao {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TutorRepository tutorRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public Tutor writeReview(Tutor tutor, Student student, Review review) {
        reviewRepository.save(review);
        studentRepository.save(student);
        return tutorRepository.save(tutor);
    }
}

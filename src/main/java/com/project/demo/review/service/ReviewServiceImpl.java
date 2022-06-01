package com.project.demo.review.service;

import com.project.demo.review.dao.ReviewDao;
import com.project.demo.review.entity.Review;
import com.project.demo.security.entity.User;
import com.project.demo.security.repository.UserRepository;
import com.project.demo.student.dao.StudentDao;
import com.project.demo.student.entity.Student;
import com.project.demo.student.service.StudentService;
import com.project.demo.tutor.dao.TutorDao;
import com.project.demo.tutor.entity.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    TutorDao tutorDao;
    @Autowired
    ReviewDao reviewDao;
    @Autowired
    UserRepository userRepository;

    @Override
    public Tutor writeReview(Long tutorid, Long studentid, Review review) {
        Tutor tutorBeingWriteTo = tutorDao.getTutor(tutorid);
        Student studentWriting = studentDao.getStudent(studentid);
        Review reviewToWrite = Review.builder()
                .description(review.getDescription())
                .rating(review.getRating())
                .build();
        tutorBeingWriteTo.getReviews().add(review);
        studentWriting.getReviews().add(review);
        reviewToWrite.setStudent(studentWriting);
        reviewToWrite.setTutor(tutorBeingWriteTo);
        return reviewDao.writeReview(tutorBeingWriteTo, studentWriting, reviewToWrite);
    }


}

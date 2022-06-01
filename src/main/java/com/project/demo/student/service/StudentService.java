package com.project.demo.student.service;

import com.project.demo.review.entity.Review;
import com.project.demo.security.entity.User;
import com.project.demo.student.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    Student createProfile(Student student, Long userid);
    Student getStudent(Long id);
    Student editProfile(Student student, Long id);
    Student deleteProfile(Long id);
}
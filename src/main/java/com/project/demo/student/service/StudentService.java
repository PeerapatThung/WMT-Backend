package com.project.demo.student.service;

import com.project.demo.student.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    Student createProfile(Student student);
    Student getStudent(Long id);
}
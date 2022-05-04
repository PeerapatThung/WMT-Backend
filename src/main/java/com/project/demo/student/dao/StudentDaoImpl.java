package com.project.demo.student.dao;

import com.project.demo.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentDaoImpl implements StudentDao{
    @Autowired
    StudentRepository studentRepository;
}

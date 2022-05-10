package com.project.demo.tutor.dao;

import com.project.demo.student.dao.StudentDao;
import com.project.demo.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TutorDaoImpl implements StudentDao {
    @Autowired
    StudentRepository studentRepository;
}

package com.project.demo.student.dao;

import com.project.demo.student.entity.Student;
import com.project.demo.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student createProfile(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
}

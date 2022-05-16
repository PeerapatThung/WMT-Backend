package com.project.demo.student.dao;

import com.project.demo.student.entity.Student;

public interface StudentDao {
    Student createProfile(Student student);
    Student getStudent(Long id);
    Student editProfile(Student student);
    Student deleteProfile(Student student);
}

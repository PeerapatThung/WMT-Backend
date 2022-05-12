package com.project.demo.student.service;

import com.project.demo.student.dao.StudentDao;
import com.project.demo.student.entity.Student;
import com.project.demo.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public Student createProfile(Student student) {
        Student newStudent = Student.builder()
                .description(student.getDescription())
                .profileImg(student.getProfileImg())
                .build();
        return studentDao.createProfile(newStudent);
    }

    @Override
    public Student getStudent(Long id){
        return studentDao.getStudent(id);
    }


}

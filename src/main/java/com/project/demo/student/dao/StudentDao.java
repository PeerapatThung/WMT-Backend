package com.project.demo.student.dao;

import com.project.demo.student.entity.Student;
import com.project.demo.tutor.entity.Tutor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentDao {
    Student createProfile(Student student);
    Student getStudent(Long id);
    Student editProfile(Student student);
    Student deleteProfile(Student student);
    Student undeleteProfile(Student student);
    Page<Student> getStudents(Integer pageSize, Integer page);
    List<Student> getRankedStudents();
}

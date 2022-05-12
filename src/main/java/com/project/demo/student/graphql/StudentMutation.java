package com.project.demo.student.graphql;

import com.project.demo.student.dto.StudentDTO;
import com.project.demo.student.entity.Student;
import com.project.demo.student.service.StudentService;
import com.project.demo.util.WMTMapper;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class StudentMutation implements GraphQLMutationResolver{
    @Autowired
    StudentService studentService;
    @Transactional
    public StudentDTO createStudent(Student student){
        Student newStudent = studentService.createProfile(student);
        return WMTMapper.INSTANCE.getStudentDTO(newStudent);
    }
}

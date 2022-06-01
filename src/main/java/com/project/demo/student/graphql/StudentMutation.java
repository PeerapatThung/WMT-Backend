package com.project.demo.student.graphql;

import com.project.demo.review.entity.Review;
import com.project.demo.student.dto.StudentDTO;
import com.project.demo.student.entity.Student;
import com.project.demo.student.service.StudentService;
import com.project.demo.tutor.dto.TutorDTO;
import com.project.demo.tutor.entity.Tutor;
import com.project.demo.tutor.service.TutorService;
import com.project.demo.util.WMTMapper;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class StudentMutation implements GraphQLMutationResolver{
    @Autowired
    StudentService studentService;

    @Autowired
    TutorService tutorService;
    @Transactional
    public StudentDTO createStudent(Student student, Long userid){
        Student newStudent = studentService.createProfile(student, userid);
        return WMTMapper.INSTANCE.getStudentDTO(newStudent);
    }

    public StudentDTO editStudent(Student student, Long id){
        Student updateStudent = studentService.editProfile(student, id);
        return WMTMapper.INSTANCE.getStudentDTO(updateStudent);
    }

    public StudentDTO deleteStudent(Long id){
        Student deletingStudent = studentService.deleteProfile(id);
        return WMTMapper.INSTANCE.getStudentDTO(deletingStudent);
    }

}

package com.project.demo.tutor.graphql;

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
public class TutorMutation implements GraphQLMutationResolver{
    @Autowired
    TutorService tutorService;

    @Autowired
    StudentService studentService;

    @Transactional
    public TutorDTO createTutor(Tutor tutor){
        Tutor newTutor = tutorService.createProfile(tutor);
        return WMTMapper.INSTANCE.getTutorDTO(newTutor);
    }

    public TutorDTO editTutor(Tutor tutor, Long id){
        Tutor updateTutor = tutorService.editProfile(tutor, id);
        return WMTMapper.INSTANCE.getTutorDTO(updateTutor);
    }

    public TutorDTO deleteTutor(Long id){
        Tutor deletingTutor = tutorService.deleteProfile(id);
        return WMTMapper.INSTANCE.getTutorDTO(deletingTutor);
    }

    public TutorDTO addStudentToTutor(Long studentid, Long tutorid){
        Tutor tutor = tutorService.getTutor(tutorid);
        tutor.getStudents().add(studentService.getStudent(studentid));
        return WMTMapper.INSTANCE.getTutorDTO(tutor);
    }

}

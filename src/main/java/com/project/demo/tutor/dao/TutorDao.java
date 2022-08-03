package com.project.demo.tutor.dao;

import com.project.demo.preference.entity.Preference;
import com.project.demo.student.entity.Student;
import com.project.demo.subject.entity.Subject;
import com.project.demo.tutor.entity.Tutor;
import org.springframework.data.domain.Page;

public interface TutorDao {
    Tutor createProfile(Tutor tutor);
    Tutor getTutor(Long id);
    Tutor editProfile(Tutor tutor);
    Tutor deleteProfile(Tutor tutor);
    Tutor undeleteProfile(Tutor tutor);
    Tutor addStudentToTutor(Student student, Tutor tutor);
    Page<Tutor> getMatchTutorPaginationByName(Integer pageSize, Integer page, String name);
    Page<Tutor> getMatchTutorPaginationByStudentInput(Integer pageSize, Integer page, Preference preference, Subject subject);
    Page<Tutor> getTutors(Integer pageSize, Integer page);

}

package com.project.demo.tutor.service;

import com.project.demo.preference.entity.Preference;
import com.project.demo.security.entity.User;
import com.project.demo.security.repository.UserRepository;
import com.project.demo.student.dao.StudentDao;
import com.project.demo.student.entity.Student;
import com.project.demo.subject.entity.Subject;
import com.project.demo.tutor.dao.TutorDao;
import com.project.demo.tutor.entity.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {
    @Autowired
    TutorDao tutorDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    UserRepository userRepository;
    @Override
    public Tutor createProfile(Tutor tutor, Long userid) {
        Tutor newTutor = Tutor.builder()
                .description(tutor.getDescription())
                .profileImg(tutor.getProfileImg())
                .build();
        User attachUser = userRepository.findById(userid).orElse(null);
        for(Preference preference : tutor.getPreferences()){
            newTutor.getPreferences().add(preference);
        }
        for(Subject subject : tutor.getSubjects()){
            newTutor.getSubjects().add(subject);
        }
        newTutor.setUser(attachUser);
        attachUser.setTutor(newTutor);
        userRepository.save(attachUser);
        return tutorDao.createProfile(newTutor);
    }

    @Override
    public Tutor getTutor(Long id){
        return tutorDao.getTutor(id);
    }

    @Override
    public Tutor editProfile(Tutor tutor, Long id) {
        Tutor editedTutor = tutorDao.getTutor(id);
        editedTutor.setDescription(tutor.getDescription());
        editedTutor.setProfileImg(tutor.getProfileImg());

        editedTutor.setPreferences(new ArrayList<>());
        editedTutor.setSubjects(new ArrayList<>());
        for(Preference preference : tutor.getPreferences()){
            editedTutor.getPreferences().add(preference);
        }
        for(Subject subject : tutor.getSubjects()){
            editedTutor.getSubjects().add(subject);
        }

        return tutorDao.editProfile(editedTutor);
    }

    @Override
    public Tutor deleteProfile(Long id) {
        Tutor deletingTutor = tutorDao.getTutor(id);
        deletingTutor.setActive(false);
        return tutorDao.deleteProfile(deletingTutor);
    }

    @Override
    public Tutor addStudentToTutor(Long studentid, Long tutorid) {
        Tutor tutor = tutorDao.getTutor(tutorid);
        Student student = studentDao.getStudent(studentid);
        tutor.getStudents().add(student);
        student.getTutors().add(tutor);
        return tutorDao.addStudentToTutor(student, tutor);
    }

    @Override
    public Page<Tutor> getTutors(Integer page, Integer pageSize) {
        return tutorDao.getTutors(page,pageSize);
    }
}

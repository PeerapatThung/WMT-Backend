package com.project.demo.tutor.dao;

import com.project.demo.preference.entity.Preference;
import com.project.demo.student.dao.StudentDao;
import com.project.demo.student.entity.Student;
import com.project.demo.student.repository.StudentRepository;
import com.project.demo.subject.entity.Subject;
import com.project.demo.tutor.entity.Tutor;
import com.project.demo.tutor.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class TutorDaoImpl implements TutorDao {
    @Autowired
    TutorRepository tutorRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Tutor createProfile(Tutor tutor) {
        tutorRepository.save(tutor);
        return tutorRepository.findById(tutor.getId()).orElse(null);
    }

    @Override
    public Tutor getTutor(Long id) {
        return tutorRepository.findById(id).orElse(null);
    }

    @Override
    public Tutor editProfile(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Override
    public Tutor deleteProfile(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Override
    public Tutor undeleteProfile(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Override
    public Tutor addStudentToTutor(Student student, Tutor tutor) {
        studentRepository.save(student);
        return tutorRepository.save(tutor);
    }

    @Override
    public Page<Tutor> getMatchTutorPaginationByName(Integer pageSize, Integer page, String name) {
        return tutorRepository.findByActiveTrueAndUser_DisplaynameIgnoreCaseContainingOrActiveTrueAndUser_FirstnameIgnoreCaseContainingOrActiveTrueAndUser_LastnameIgnoreCaseContaining
                (name, name, name, PageRequest.of(page-1,pageSize));
    }

    @Override
    public Page<Tutor> getMatchTutorPaginationByStudentInput(Integer pageSize, Integer page, Preference preference, Subject subject) {
        if(preference.getId() == null){
            return tutorRepository.findBySubjects_IdAndActiveTrue(subject.getId(), PageRequest.of(page-1,pageSize));
        }
        else if(subject.getId() == null){
            return tutorRepository.findByPreferences_IdAndActiveTrue(preference.getId(), PageRequest.of(page-1,pageSize));
        }
        else return tutorRepository.findByPreferences_IdAndSubjects_IdAndActiveTrue(preference.getId(), subject.getId(), PageRequest.of(page-1,pageSize));
    }

    @Override
    public Page<Tutor> getTutors(Integer pageSize, Integer page) {
        return tutorRepository.findByActiveTrue(PageRequest.of(page-1, pageSize));
    }

}

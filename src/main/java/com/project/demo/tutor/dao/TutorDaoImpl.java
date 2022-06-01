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
        return tutorRepository.save(tutor);
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
    public Tutor addStudentToTutor(Student student, Tutor tutor) {
        studentRepository.save(student);
        return tutorRepository.save(tutor);
    }

    @Override
    public Page<Tutor> getMatchTutorPaginationByName(Integer pageSize, Integer page, String name) {
        return tutorRepository.findByUser_DisplaynameIgnoreCaseContainingAndActiveTrue(name, PageRequest.of(page-1,pageSize));
    }

    @Override
    public Page<Tutor> getMatchTutorPaginationByStudentInput(Integer page, Integer pageSize, Preference preference, Subject subject) {
        return tutorRepository.findByPreferencesContainsAndSubjectsContainsAndActiveTrue(preference, subject, PageRequest.of(page-1,pageSize));
    }

}

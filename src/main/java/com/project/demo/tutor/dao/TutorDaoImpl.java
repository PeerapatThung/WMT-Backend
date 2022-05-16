package com.project.demo.tutor.dao;

import com.project.demo.student.dao.StudentDao;
import com.project.demo.student.entity.Student;
import com.project.demo.student.repository.StudentRepository;
import com.project.demo.tutor.entity.Tutor;
import com.project.demo.tutor.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TutorDaoImpl implements TutorDao {
    @Autowired
    TutorRepository tutorRepository;

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

}

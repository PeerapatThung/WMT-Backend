package com.project.demo.tutormatch.service;

import com.project.demo.preference.entity.Preference;
import com.project.demo.security.entity.User;
import com.project.demo.security.repository.UserRepository;
import com.project.demo.student.dao.StudentDao;
import com.project.demo.student.entity.Student;
import com.project.demo.student.service.StudentService;
import com.project.demo.subject.entity.Subject;
import com.project.demo.tutor.dao.TutorDao;
import com.project.demo.tutor.entity.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class TutorMatchServiceImpl implements TutorMatchService {
    @Autowired
    TutorDao tutorDao;
    @Override
    public Page<Tutor> getMatchTutorPaginationByName(Integer page, Integer pageSize, String name) {
        return tutorDao.getMatchTutorPaginationByName(page,pageSize,name);
    }

    @Override
    public Page<Tutor> getMatchTutorPaginationByStudentInput(Integer page, Integer pageSize, Preference preference, Subject subject) {
        return tutorDao.getMatchTutorPaginationByStudentInput(page,pageSize,preference,subject);
    }
}

package com.project.demo.tutor.service;

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

    @Override
    public Tutor createProfile(Tutor tutor) {
        Tutor newTutor = Tutor.builder()
                .description(tutor.getDescription())
                .profileImg(tutor.getProfileImg())
                .build();
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
        return tutorDao.editProfile(editedTutor);
    }

    @Override
    public Tutor deleteProfile(Long id) {
        Tutor deletingTutor = tutorDao.getTutor(id);
        deletingTutor.setActive(false);
        return tutorDao.deleteProfile(deletingTutor);
    }
}

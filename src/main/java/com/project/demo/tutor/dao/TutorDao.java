package com.project.demo.tutor.dao;

import com.project.demo.tutor.entity.Tutor;

public interface TutorDao {
    Tutor createProfile(Tutor tutor);
    Tutor getTutor(Long id);
    Tutor editProfile(Tutor tutor);
    Tutor deleteProfile(Tutor tutor);
}

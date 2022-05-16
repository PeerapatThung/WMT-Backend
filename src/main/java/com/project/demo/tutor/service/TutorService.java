package com.project.demo.tutor.service;

import com.project.demo.tutor.entity.Tutor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TutorService {
    Tutor createProfile(Tutor tutor);
    Tutor getTutor(Long id);
    Tutor editProfile(Tutor tutor, Long id);
    Tutor deleteProfile(Long id);
}
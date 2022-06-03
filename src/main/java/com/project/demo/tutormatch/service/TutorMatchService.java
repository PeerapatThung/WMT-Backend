package com.project.demo.tutormatch.service;

import com.project.demo.preference.entity.Preference;
import com.project.demo.student.entity.Student;
import com.project.demo.subject.entity.Subject;
import com.project.demo.tutor.entity.Tutor;
import org.springframework.data.domain.Page;

public interface TutorMatchService {
    Page<Tutor> getMatchTutorPaginationByName(Integer page, Integer pageSize, String name);
    Page<Tutor> getMatchTutorPaginationByStudentInput(Integer page, Integer pageSize, Preference preference, Subject subject);
}
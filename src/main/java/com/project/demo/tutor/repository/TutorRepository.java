package com.project.demo.tutor.repository;

import com.project.demo.preference.entity.Preference;
import com.project.demo.student.entity.Student;
import com.project.demo.subject.entity.Subject;
import com.project.demo.tutor.entity.Tutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    Page<Tutor> findByUser_DisplaynameIgnoreCaseContainingAndActiveTrue(String name, Pageable pageRequest);
    Page<Tutor> findByPreferencesContainsAndSubjectsContainsAndActiveTrue
            (Preference preferences, Subject subject, Pageable pageRequest);
}


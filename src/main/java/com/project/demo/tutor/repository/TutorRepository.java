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
    Page<Tutor> findByUser_DisplaynameIgnoreCaseContainingOrUser_FirstnameIgnoreCaseContainingOrUser_LastnameIgnoreCaseContainingAndActiveTrue
            (String displayname, String firstname, String lastname, Pageable pageRequest);
    Page<Tutor> findByPreferences_IdAndSubjects_IdAndActiveTrue
            (Long preferences_id, Long subjects_id, Pageable pageable);
    Page<Tutor> findByPreferences_IdAndActiveTrue
            (Long preferences_id, Pageable pageable);
    Page<Tutor> findBySubjects_IdAndActiveTrue
            (Long subjects_id, Pageable pageable);
    Page<Tutor> findByActiveTrue(Pageable pageable);
}


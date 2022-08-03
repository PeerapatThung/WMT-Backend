package com.project.demo.subject.repository;

import com.project.demo.subject.entity.Subject;
import com.project.demo.tutor.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findByCategory_Id(Long categoryid);
}


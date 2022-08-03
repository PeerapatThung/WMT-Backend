package com.project.demo.student.repository;

import com.project.demo.student.entity.Student;
import com.project.demo.tutor.entity.Tutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findByActiveTrue(Pageable pageable);
}

package com.project.demo.request.repository;

import com.project.demo.request.entity.Request;
import com.project.demo.request.entity.RequestStatus;
import com.project.demo.student.entity.Student;
import com.project.demo.tutor.entity.Tutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
    Page<Request> findByTutor_IdAndStatus(Long tutorid, RequestStatus status, Pageable pageable);
    Page<Request> findByStudent_Id(Long studentid, Pageable pageable);
}

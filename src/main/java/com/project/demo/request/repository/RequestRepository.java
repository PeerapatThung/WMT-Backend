package com.project.demo.request.repository;

import com.project.demo.request.entity.Request;
import com.project.demo.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {

}

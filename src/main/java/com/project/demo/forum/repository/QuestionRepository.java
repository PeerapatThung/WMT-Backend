package com.project.demo.forum.repository;

import com.project.demo.forum.entity.ForumStatus;
import com.project.demo.forum.entity.Question;
import com.project.demo.request.entity.Request;
import com.project.demo.request.entity.RequestStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Page<Question> findByCategory_Id(Long id, Pageable pageable);
    Page<Question> findAll(Pageable pageable);
}

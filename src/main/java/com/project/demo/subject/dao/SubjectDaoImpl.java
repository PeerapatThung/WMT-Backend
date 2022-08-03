package com.project.demo.subject.dao;

import com.project.demo.review.entity.Review;
import com.project.demo.review.repository.ReviewRepository;
import com.project.demo.student.entity.Student;
import com.project.demo.student.repository.StudentRepository;
import com.project.demo.subject.entity.Category;
import com.project.demo.subject.entity.Subject;
import com.project.demo.subject.repository.CategoryRepository;
import com.project.demo.subject.repository.SubjectRepository;
import com.project.demo.tutor.entity.Tutor;
import com.project.demo.tutor.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectDaoImpl implements SubjectDao {
    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Subject> getSubjects(Long categoryid) {
        return subjectRepository.findByCategory_Id(categoryid);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}

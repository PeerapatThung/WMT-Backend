package com.project.demo.subject.dao;

import com.project.demo.review.entity.Review;
import com.project.demo.student.entity.Student;
import com.project.demo.subject.entity.Category;
import com.project.demo.subject.entity.Subject;
import com.project.demo.tutor.entity.Tutor;

import java.util.List;

public interface SubjectDao {
    List<Subject> getSubjects(Long categoryid);
    List<Category> getCategories();
}

package com.project.demo.subject.service;

import com.project.demo.preference.entity.Preference;
import com.project.demo.subject.entity.Category;
import com.project.demo.subject.entity.Subject;
import com.project.demo.tutor.entity.Tutor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SubjectService {
    List<Subject> getSubjects(Long categoryid);
    List<Category> getCategories();
}
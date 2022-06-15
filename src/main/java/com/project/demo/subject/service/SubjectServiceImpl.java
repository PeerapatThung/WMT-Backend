package com.project.demo.subject.service;

import com.project.demo.preference.entity.Preference;
import com.project.demo.subject.dao.SubjectDao;
import com.project.demo.subject.entity.Category;
import com.project.demo.subject.entity.Subject;
import com.project.demo.subject.repository.CategoryRepository;
import com.project.demo.tutor.dao.TutorDao;
import com.project.demo.tutor.entity.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectDao subjectDao;

    @Override
    public List<Subject> getSubjects(Long categoryid) {
        return subjectDao.getSubjects(categoryid);
    }

    @Override
    public List<Category> getCategories() {
        return subjectDao.getCategories();
    }
}

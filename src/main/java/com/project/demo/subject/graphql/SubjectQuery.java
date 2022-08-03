package com.project.demo.subject.graphql;

import com.project.demo.student.dto.StudentDTO;
import com.project.demo.student.entity.Student;
import com.project.demo.student.service.StudentService;
import com.project.demo.subject.dto.CategoryDTO;
import com.project.demo.subject.dto.SubjectDTO;
import com.project.demo.subject.entity.Category;
import com.project.demo.subject.entity.Subject;
import com.project.demo.subject.repository.CategoryRepository;
import com.project.demo.subject.service.SubjectService;
import com.project.demo.util.WMTMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class SubjectQuery implements GraphQLQueryResolver {
    @Autowired
    SubjectService subjectService;

    @Transactional
    public List<SubjectDTO> getSubjects(Long categoryid) {
        List<Subject> subjects = subjectService.getSubjects(categoryid);
        return WMTMapper.INSTANCE.getSubjectsDTO(subjects);
    }

    public List<CategoryDTO> getCategories() {
        List<Category> categories = subjectService.getCategories();
        return WMTMapper.INSTANCE.getCategoriesDTO(categories);
    }
}

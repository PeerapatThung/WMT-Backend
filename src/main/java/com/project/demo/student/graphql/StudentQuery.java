package com.project.demo.student.graphql;

import com.project.demo.util.WMTMapper;
import com.project.demo.student.service.StudentService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class StudentQuery implements GraphQLQueryResolver {
    @Autowired
    StudentService studentService;

}

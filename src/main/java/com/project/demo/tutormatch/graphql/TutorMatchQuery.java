package com.project.demo.tutormatch.graphql;

import com.project.demo.preference.entity.Preference;
import com.project.demo.student.dto.StudentDTO;
import com.project.demo.student.entity.Student;
import com.project.demo.student.service.StudentService;
import com.project.demo.subject.entity.Subject;
import com.project.demo.tutor.dto.TutorDTO;
import com.project.demo.tutor.entity.Tutor;
import com.project.demo.tutormatch.service.TutorMatchService;
import com.project.demo.util.QueryFilter;
import com.project.demo.util.WMTMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class TutorMatchQuery implements GraphQLQueryResolver {
    @Autowired
    TutorMatchService tutorMatchService;

    @Transactional
    List<TutorDTO> getMatchTutorPaginationByName(QueryFilter queryFilter, String name) {
        Page<Tutor> tutors = tutorMatchService.getMatchTutorPaginationByName(queryFilter.getPageSize(), queryFilter.getPageNo(), name);
        return WMTMapper.INSTANCE.getTutorsDTO(tutors.getContent());
    }
    @Transactional
    List<TutorDTO> getMatchTutorPaginationByStudentInput(QueryFilter queryFilter, Preference preference, Subject subject) {
        Page<Tutor> tutors = tutorMatchService.getMatchTutorPaginationByStudentInput(queryFilter.getPageSize(), queryFilter.getPageNo(), preference, subject);
        return WMTMapper.INSTANCE.getTutorsDTO(tutors.getContent());
    }
}

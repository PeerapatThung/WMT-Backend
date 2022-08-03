package com.project.demo.tutor.graphql;

import com.project.demo.tutor.dto.TutorDTO;
import com.project.demo.tutor.entity.Tutor;
import com.project.demo.tutor.service.TutorService;
import com.project.demo.util.QueryFilter;
import com.project.demo.util.WMTMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class TutorQuery implements GraphQLQueryResolver {
    @Autowired
    TutorService tutorService;

    @Transactional
    public TutorDTO getTutor(Long id) {
        Tutor tutor = tutorService.getTutor(id);
        return WMTMapper.INSTANCE.getTutorDTO(tutor);
    }

//    List<TutorDTO> getAllTutors() {
//        List<Tutor> tutors = tutorService.getTutors(queryFilter.getPageSize(), queryFilter.getPageNo());
//        return WMTMapper.INSTANCE.getTutorsDTO(tutors.getContent());
//    }

    public Page<Tutor> getTutors(QueryFilter queryFilter) {
        return tutorService.getTutors(queryFilter.getPageSize(), queryFilter.getPageNo());
    }

}

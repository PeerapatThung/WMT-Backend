package com.project.demo.request.graphql;

import com.project.demo.request.dto.RequestDTO;
import com.project.demo.request.entity.Request;
import com.project.demo.request.repository.RequestRepository;
import com.project.demo.request.service.RequestService;
import com.project.demo.student.dto.StudentDTO;
import com.project.demo.student.entity.Student;
import com.project.demo.student.service.StudentService;
import com.project.demo.util.QueryFilter;
import com.project.demo.util.WMTMapper;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class RequestQuery implements GraphQLQueryResolver {
    @Autowired
    RequestService requestService;

    @Transactional
    List<RequestDTO> getRequestsTutorSide(QueryFilter queryFilter, Long tutorid) {
        Page<Request> request = requestService.getRequestsTutorSide(queryFilter.getPageSize(), queryFilter.getPageNo(), tutorid);
        return WMTMapper.INSTANCE.getRequestsDTO(request.getContent());
    }

    @Transactional
    List<RequestDTO> getRequestsStudentSide(QueryFilter queryFilter, Long studentid) {
        Page<Request> request = requestService.getRequestsStudentSide(queryFilter.getPageSize(), queryFilter.getPageNo(), studentid);
        return WMTMapper.INSTANCE.getRequestsDTO(request.getContent());
    }
}

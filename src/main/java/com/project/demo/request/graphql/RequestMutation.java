package com.project.demo.request.graphql;

import com.project.demo.request.dto.RequestDTO;
import com.project.demo.request.entity.Request;
import com.project.demo.request.service.RequestService;
import com.project.demo.review.entity.Review;
import com.project.demo.review.service.ReviewService;
import com.project.demo.tutor.dto.TutorDTO;
import com.project.demo.tutor.entity.Tutor;
import com.project.demo.tutor.service.TutorService;
import com.project.demo.util.WMTMapper;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestMutation implements GraphQLMutationResolver{
    @Autowired
    RequestService requestService;

    public RequestDTO sendRequest(Long tutorid, Long studentid, Request request){
        Request requestToWrite = requestService.writeRequest(tutorid, studentid, request);
        return WMTMapper.INSTANCE.getRequestDTO(requestToWrite);
    }

    public RequestDTO rejectRequest(Request request){
        Request requestToReject = requestService.rejectRequest(request);
        return WMTMapper.INSTANCE.getRequestDTO(requestToReject);
    }

    public RequestDTO acceptRequest(Request request){
        Request requestToAccept = requestService.acceptRequest(request);
        return WMTMapper.INSTANCE.getRequestDTO(requestToAccept);
    }


}

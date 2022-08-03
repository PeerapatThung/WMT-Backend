package com.project.demo.request.service;

import com.project.demo.request.entity.Request;
import com.project.demo.review.entity.Review;
import com.project.demo.tutor.entity.Tutor;
import org.springframework.data.domain.Page;

public interface RequestService {
    Request writeRequest(Long tutorid, Long studentid, Request request);
    Request rejectRequest(Request request);
    Request acceptRequest(Request request);
    Page<Request> getRequestsTutorSide(Integer page, Integer pageSize,Long tutorid);
    Page<Request> getRequestsStudentSide(Integer page, Integer pageSize, Long studentid);
}
package com.project.demo.request.service;

import com.project.demo.request.entity.Request;
import com.project.demo.review.entity.Review;
import com.project.demo.tutor.entity.Tutor;

public interface RequestService {
    Request writeRequest(Long tutorid, Long studentid, Request request);
    Request rejectRequest(Request request);
    Request acceptRequest(Request request);
}
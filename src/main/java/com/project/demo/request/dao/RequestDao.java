package com.project.demo.request.dao;

import com.project.demo.request.entity.Request;
import com.project.demo.review.entity.Review;
import com.project.demo.student.entity.Student;
import com.project.demo.tutor.entity.Tutor;

public interface RequestDao {
    Request writeRequest(Tutor tutorid, Student studentid, Request request);
    Request getRequest(Long id);
    Request rejectRequest(Request request);
    Request acceptRequest(Request request);
}

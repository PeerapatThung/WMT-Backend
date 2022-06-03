package com.project.demo.request.dao;

import com.project.demo.request.entity.Request;
import com.project.demo.request.repository.RequestRepository;
import com.project.demo.review.dao.ReviewDao;
import com.project.demo.review.entity.Review;
import com.project.demo.review.repository.ReviewRepository;
import com.project.demo.student.entity.Student;
import com.project.demo.student.repository.StudentRepository;
import com.project.demo.tutor.entity.Tutor;
import com.project.demo.tutor.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class RequestDaoImpl implements RequestDao {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TutorRepository tutorRepository;

    @Autowired
    RequestRepository requestRepository;

    @Override
    public Request writeRequest(Tutor tutor, Student student, Request request) {
        return requestRepository.save(request);
    }

    @Override
    public Request getRequest(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    @Override
    public Request rejectRequest(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public Request acceptRequest(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public Page<Request> getRequestsTutorSide(Integer pageSize, Integer page, Long tutorid) {
        return requestRepository.findByTutor_Id(tutorid, PageRequest.of(page-1,pageSize));
    }

    @Override
    public Page<Request> getRequestsStudentSide(Integer pageSize, Integer page,Long studentid) {
        return requestRepository.findByStudent_Id(studentid, PageRequest.of(page-1,pageSize));
    }
}

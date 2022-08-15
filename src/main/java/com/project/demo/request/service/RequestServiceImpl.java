package com.project.demo.request.service;

import com.project.demo.request.dao.RequestDao;
import com.project.demo.request.entity.Request;
import com.project.demo.request.entity.RequestStatus;
import com.project.demo.review.dao.ReviewDao;
import com.project.demo.review.entity.Review;
import com.project.demo.review.service.ReviewService;
import com.project.demo.security.repository.UserRepository;
import com.project.demo.student.dao.StudentDao;
import com.project.demo.student.entity.Student;
import com.project.demo.tutor.dao.TutorDao;
import com.project.demo.tutor.entity.Tutor;
import com.project.demo.tutor.service.TutorService;
import com.project.demo.util.WMTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    TutorDao tutorDao;
    @Autowired
    RequestDao requestDao;

    @Override
    public Request writeRequest(Long tutorid, Long studentid, Request request) {
        Tutor tutorBeingWriteTo = tutorDao.getTutor(tutorid);
        Student studentWriting = studentDao.getStudent(studentid);
        Request requestToWrite = Request.builder()
                .message(request.getMessage())
                .status(RequestStatus.Pending)
                .build();
        tutorBeingWriteTo.getRequests().add(request);
        studentWriting.getRequests().add(request);
        requestToWrite.setStudent(studentWriting);
        requestToWrite.setTutor(tutorBeingWriteTo);
        return requestDao.writeRequest(tutorBeingWriteTo, studentWriting, requestToWrite);
    }

    @Override
    public Request rejectRequest(Request request) {
        Request requestToReject = requestDao.getRequest(request.getId());
        requestToReject.setReply(request.getReply());
        requestToReject.setStatus(RequestStatus.Rejected);
        return requestDao.rejectRequest(requestToReject);
    }

    @Override
    public Request acceptRequest(Request request) {
        Request requestToAccept = requestDao.getRequest(request.getId());
        requestToAccept.setReply(request.getReply());
        requestToAccept.setStatus(RequestStatus.Accepted);
        Tutor tutor = tutorDao.getTutor(requestToAccept.getTutor().getId());
        Student student = studentDao.getStudent(requestToAccept.getStudent().getId());
        tutor.getStudents().add(student);
        student.getTutors().add(tutor);
        tutorDao.addStudentToTutor(student, tutor);
        return requestDao.acceptRequest(requestToAccept);
    }

    @Override
    public Request getRequest(Long id) {
        return requestDao.getRequest(id);
    }

    @Override
    public Page<Request> getRequestsTutorSide(Integer page, Integer pageSize, Long tutorid) {
        return requestDao.getRequestsTutorSide(page,pageSize,tutorid);
    }

    @Override
    public Page<Request> getRequestsStudentSide(Integer page, Integer pageSize, Long studentid) {
        return requestDao.getRequestsStudentSide(page,pageSize,studentid);
    }


}

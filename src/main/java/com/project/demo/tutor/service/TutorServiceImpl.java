package com.project.demo.tutor.service;

import com.project.demo.student.repository.StudentRepository;
import com.project.demo.student.service.StudentService;
import com.project.demo.tutor.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {
    @Autowired
    TutorRepository tutorRepository;
}

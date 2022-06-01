package com.project.demo.review.graphql;

import com.project.demo.review.entity.Review;
import com.project.demo.review.service.ReviewService;
import com.project.demo.student.dto.StudentDTO;
import com.project.demo.student.entity.Student;
import com.project.demo.student.service.StudentService;
import com.project.demo.tutor.dto.TutorDTO;
import com.project.demo.tutor.entity.Tutor;
import com.project.demo.tutor.service.TutorService;
import com.project.demo.util.WMTMapper;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ReviewMutation implements GraphQLMutationResolver{
    @Autowired
    ReviewService reviewService;

    @Autowired
    TutorService tutorService;

    public TutorDTO writeReview(Long tutorid, Long studentid, Review review){
        Tutor tutor = reviewService.writeReview(tutorid, studentid, review);
        return WMTMapper.INSTANCE.getTutorDTO(tutor);
    }
}

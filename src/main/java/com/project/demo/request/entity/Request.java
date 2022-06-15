package com.project.demo.request.entity;

import com.project.demo.review.entity.Review;
import com.project.demo.security.entity.AuthorityName;
import com.project.demo.security.entity.User;
import com.project.demo.student.entity.Student;
import com.project.demo.tutor.entity.Tutor;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    private String message;
    private String reply;
    @ManyToOne
    private Tutor tutor;
    @ManyToOne
    private Student student;
    @Enumerated(EnumType.STRING)
    private RequestStatus status;
}



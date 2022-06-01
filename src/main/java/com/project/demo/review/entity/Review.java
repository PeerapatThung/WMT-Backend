package com.project.demo.review.entity;

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
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    String description;
    @Builder.Default
    double rating = 1.0;

    @ManyToOne
    Tutor tutor;

    @ManyToOne
    Student student;
}



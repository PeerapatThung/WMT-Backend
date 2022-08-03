package com.project.demo.tutor.entity;

import com.project.demo.preference.entity.Preference;
import com.project.demo.request.entity.Request;
import com.project.demo.review.entity.Review;
import com.project.demo.security.entity.User;
import com.project.demo.student.entity.Student;
import com.project.demo.subject.entity.Category;
import com.project.demo.subject.entity.Subject;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tutor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    private String description;
    private String profileImg;
    @Builder.Default
    private double overallRating = 0.0;
    @Builder.Default
    private double totalRating = 0.0;
    @Builder.Default
    private Integer reviewReceived = 0;
    @Builder.Default
    private boolean active = true;

    @ManyToMany
    @Builder.Default
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Preference> preferences = new ArrayList<>();

    @ManyToMany
    @Builder.Default
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Subject> subjects = new ArrayList<>();

    @ManyToMany
    @Builder.Default
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Student> students = new ArrayList<>();
    @OneToOne(mappedBy = "tutor")
    private User user;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    @Builder.Default
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "tutor")
    @Builder.Default
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Request> requests = new ArrayList<>();
}



package com.project.demo.student.entity;

import com.project.demo.forum.entity.Answer;
import com.project.demo.forum.entity.Question;
import com.project.demo.request.entity.Request;
import com.project.demo.review.entity.Review;
import com.project.demo.security.entity.User;
import com.project.demo.tutor.entity.Tutor;
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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    private String description;
    private String profileImg;
    @Builder.Default
    private boolean active = true;

    @Builder.Default
    private Integer rewardPoints = 0;

    @ManyToMany
    @Builder.Default
            @LazyCollection(LazyCollectionOption.FALSE)
    private List<Tutor> tutors = new ArrayList<>();
    @OneToOne(mappedBy = "student")
    private User user;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @Builder.Default
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @Builder.Default
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Request> requests = new ArrayList<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @Builder.Default
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Question> questions = new ArrayList<>();

    @ManyToMany
    @Builder.Default
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Answer> votes = new ArrayList<>();
}



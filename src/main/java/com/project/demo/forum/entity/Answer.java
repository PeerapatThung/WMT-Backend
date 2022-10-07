package com.project.demo.forum.entity;

import com.project.demo.preference.entity.Preference;
import com.project.demo.request.entity.RequestStatus;
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
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    private String description;
    @ManyToMany
    @Builder.Default
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Student> votedBy = new ArrayList<>();
    @Builder.Default
    private Integer votes = 0;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ForumStatus status = ForumStatus.Open;
    @ManyToOne
    private Question question;
    @ManyToOne
    private Tutor tutor;
}

package com.project.demo.forum.entity;

import com.project.demo.student.entity.Student;
import com.project.demo.subject.entity.Category;
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
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    private Student student;
    @OneToMany(mappedBy = "question")
    @Builder.Default
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Answer> answers = new ArrayList<>();
    @ManyToOne
    private Category category;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ForumStatus status = ForumStatus.Ongoing;
}

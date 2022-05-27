package com.project.demo.subject.entity;

import com.project.demo.security.entity.User;
import com.project.demo.tutor.entity.Tutor;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    String name;
    @ManyToOne
    Category category;
    @ManyToMany
    @Builder.Default
    List<Tutor> tutors = new ArrayList<>();
}



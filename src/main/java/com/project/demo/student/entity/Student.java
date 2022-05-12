package com.project.demo.student.entity;

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
    String description;
    String profileImg;

    @ManyToMany
    @Builder.Default
    List<Tutor> tutors = new ArrayList<>();
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    User user;
}



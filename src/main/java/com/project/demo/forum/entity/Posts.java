package com.project.demo.forum.entity;

import com.project.demo.student.entity.Student;
import com.project.demo.tutor.entity.Tutor;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    private String description;
    @Builder.Default
    private LocalDateTime lastOpened = LocalDateTime.now(ZoneId.of("GMT+07"));
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ForumStatus status = ForumStatus.Open;
    @OneToOne
    private Tutor tutor;
}

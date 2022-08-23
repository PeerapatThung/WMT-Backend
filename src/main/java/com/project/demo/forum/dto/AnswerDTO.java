package com.project.demo.forum.dto;

import com.project.demo.forum.entity.ForumStatus;
import com.project.demo.forum.entity.Question;
import com.project.demo.student.dto.StudentDTO;
import com.project.demo.student.entity.Student;
import com.project.demo.tutor.dto.TutorDTO;
import com.project.demo.tutor.entity.Tutor;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {
    private Long id;
    private String description;
    private List<StudentDTO> votedBy;
    private Integer votes;
    private String status;
    private TutorDTO tutor;
}

package com.project.demo.forum.dto;

import com.project.demo.forum.entity.Answer;
import com.project.demo.forum.entity.ForumStatus;
import com.project.demo.forum.entity.Question;
import com.project.demo.student.dto.StudentDTO;
import com.project.demo.student.entity.Student;
import com.project.demo.subject.dto.CategoryDTO;
import com.project.demo.subject.entity.Category;
import com.project.demo.tutor.dto.TutorDTO;
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
public class QuestionDTO {
    private Long id;
    private String description;
    private String title;
    private StudentDTO student;
    private List<AnswerDTO> answers;
    private CategoryDTO category;
    private String status;
}

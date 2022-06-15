package com.project.demo.review.dto;

import com.project.demo.security.entity.UserDTO;
import com.project.demo.student.dto.StudentDTO;
import com.project.demo.student.dto.TeachingTutorDTO;
import com.project.demo.student.entity.Student;
import com.project.demo.tutor.dto.StudentInCareDTO;
import com.project.demo.tutor.entity.Tutor;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long id;
    private String description;
    private double rating;
    private StudentInCareDTO student;
}



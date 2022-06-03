package com.project.demo.request.dto;

import com.project.demo.student.dto.TeachingTutorDTO;
import com.project.demo.student.entity.Student;
import com.project.demo.tutor.dto.StudentInCareDTO;
import com.project.demo.tutor.entity.Tutor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {
    Long id;
    String message;
    String reply;
    TeachingTutorDTO tutor;
    StudentInCareDTO student;
    String status;
}



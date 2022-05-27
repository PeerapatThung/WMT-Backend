package com.project.demo.tutor.dto;

import com.project.demo.security.entity.UserDTO;
import com.project.demo.student.dto.TeachingTutorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentInCareDTO {
    Long id;
    UserDTO user;
}



package com.project.demo.student.dto;

import com.project.demo.security.entity.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeachingTutorDTO {
    private Long id;
    private UserDTO user;
}



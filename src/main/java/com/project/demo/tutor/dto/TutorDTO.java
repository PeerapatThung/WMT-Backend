package com.project.demo.tutor.dto;

import com.project.demo.security.entity.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TutorDTO {
    Long id;
    String description;
    String profileImg;
    UserDTO user;
}



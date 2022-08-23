package com.project.demo.student.dto;

import com.project.demo.security.entity.User;
import com.project.demo.security.entity.UserDTO;
import com.project.demo.tutor.entity.Tutor;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String description;
    private String profileImg;
    private boolean active;
    private List<TeachingTutorDTO> tutors;
    private UserDTO user;
    private Integer rewardPoints;
}



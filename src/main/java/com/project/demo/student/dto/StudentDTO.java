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
    Long id;
    String description;
    String profileImg;
    UserDTO user;
}



package com.project.demo.security.entity;

import com.project.demo.student.dto.StudentDTO;
import com.project.demo.tutor.dto.TutorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    String username;
    String password;
    String email;
    String firstname;
    String lastname;
    List<AuthorityDTO> authorities;
    String id;
    String displayname;
    TutorUser tutor;
    StudentUser student;
}

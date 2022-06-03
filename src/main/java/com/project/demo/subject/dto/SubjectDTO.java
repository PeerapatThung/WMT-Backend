package com.project.demo.subject.dto;

import com.project.demo.security.entity.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
    Long id;
    String name;
    CategoryDTO category;
}



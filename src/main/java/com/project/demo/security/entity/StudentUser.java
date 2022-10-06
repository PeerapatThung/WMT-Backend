package com.project.demo.security.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentUser {
    private Long id;
    private String profileImg;
    private List<TutorUser> tutors;
}



package com.project.demo.tutor.dto;

import com.project.demo.preference.dto.PreferenceDTO;
import com.project.demo.review.dto.ReviewDTO;
import com.project.demo.security.entity.UserDTO;
import com.project.demo.subject.dto.SubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TutorDTO {
    Long id;
    String description;
    String profileImg;
    double overallRating;
    List<StudentInCareDTO> students;
    List<SubjectDTO> subjects;
    List<PreferenceDTO> preferences;
    boolean active;
    UserDTO user;
    List<ReviewDTO> reviews;
}



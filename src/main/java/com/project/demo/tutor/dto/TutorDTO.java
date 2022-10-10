package com.project.demo.tutor.dto;

import com.project.demo.forum.dto.AnswerDTO;
import com.project.demo.forum.dto.PostTutorDTO;
import com.project.demo.forum.entity.Answer;
import com.project.demo.preference.dto.PreferenceDTO;
import com.project.demo.request.dto.RequestDTO;
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
    private Long id;
    private String description;
    private String profileImg;
    private double overallRating;
    private List<StudentInCareDTO> students;
    private List<SubjectDTO> subjects;
    private List<PreferenceDTO> preferences;
    private List<RequestDTO> requests;
    private boolean active;
    private UserDTO user;
    private List<ReviewDTO> reviews;
    private Integer reviewReceived;
    private Integer rewardPoints;
    private PostTutorDTO posts;
}



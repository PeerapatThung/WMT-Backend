package com.project.demo.forum.dto;

import com.project.demo.forum.entity.ForumStatus;
import com.project.demo.tutor.entity.Tutor;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long id;
    private String description;
    private LocalDateTime lastOpened;
    private ForumStatus status;
    private Tutor tutor;
}

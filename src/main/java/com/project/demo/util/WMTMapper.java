package com.project.demo.util;

import com.project.demo.student.dto.StudentDTO;
import com.project.demo.student.entity.Student;
import com.project.demo.tutor.dto.TutorDTO;
import com.project.demo.tutor.entity.Tutor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.project.demo.security.entity.User;
import com.project.demo.security.entity.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface WMTMapper {
    WMTMapper INSTANCE = Mappers.getMapper(WMTMapper.class);
    List<UserDTO> getUserDTO(List<User> user);
    UserDTO getUserDto(User user);
    StudentDTO getStudentDTO(Student student);
    TutorDTO getTutorDTO(Tutor tutor);
}

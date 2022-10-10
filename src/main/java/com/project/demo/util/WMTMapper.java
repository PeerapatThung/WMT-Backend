package com.project.demo.util;

import com.project.demo.forum.dto.AnswerDTO;
import com.project.demo.forum.dto.PostDTO;
import com.project.demo.forum.dto.QuestionDTO;
import com.project.demo.forum.entity.Answer;
import com.project.demo.forum.entity.Posts;
import com.project.demo.forum.entity.Question;
import com.project.demo.preference.dto.PreferenceDTO;
import com.project.demo.preference.entity.Preference;
import com.project.demo.request.dto.RequestDTO;
import com.project.demo.request.entity.Request;
import com.project.demo.student.dto.StudentDTO;
import com.project.demo.student.entity.Student;
import com.project.demo.subject.dto.CategoryDTO;
import com.project.demo.subject.dto.SubjectDTO;
import com.project.demo.subject.entity.Category;
import com.project.demo.subject.entity.Subject;
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
    List<TutorDTO> getTutorsDTO(List<Tutor> tutors);
    RequestDTO getRequestDTO(Request request);
    List<RequestDTO> getRequestsDTO(List<Request> requests);
    List<SubjectDTO> getSubjectsDTO(List<Subject> subjects);
    List<PreferenceDTO> getPreferencesDTO(List<Preference> preference);
    List<CategoryDTO> getCategoriesDTO(List<Category> categories);
    List<AnswerDTO> getAnswersDTO(List<Answer> answers);
    List<StudentDTO> getStudentsDTO(List<Student> students);

    QuestionDTO getQuestionDTO(Question question);
    AnswerDTO getAnswerDTO(Answer answer);
    PostDTO getPostDTO(Posts post);
}
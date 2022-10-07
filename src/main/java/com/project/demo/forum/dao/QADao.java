package com.project.demo.forum.dao;

import com.project.demo.forum.entity.Answer;
import com.project.demo.forum.entity.Posts;
import com.project.demo.forum.entity.Question;
import com.project.demo.student.entity.Student;
import com.project.demo.tutor.entity.Tutor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface QADao {
    Page<Question> getAllQuestions(Integer page, Integer pageSize);
    Page<Question> getQuestionsByCategory(Long categoryid, Integer page, Integer pageSize);
    List<Answer> getAnswers(Long questionid);
    Question askQuestion(Student student, Question question);
    Answer answerQuestion(Tutor tutor, Long questionid, Answer answer);
    Question resolveQuestion(Question question, Answer answer);
    Question lockQuestion(Question question);
    Question getQuestion(Long id);
    Answer getAnswer(Long id);
    Answer voteAnswer(Student student, Tutor tutor, Answer answer);
    Posts updatePost(Posts post);
    Posts closePost(Posts post);
    Page<Posts> getPosts(Integer page, Integer pageSize);
}

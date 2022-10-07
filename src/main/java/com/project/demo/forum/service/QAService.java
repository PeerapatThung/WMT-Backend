package com.project.demo.forum.service;

import com.project.demo.forum.entity.Answer;
import com.project.demo.forum.entity.Posts;
import com.project.demo.forum.entity.Question;
import com.project.demo.request.entity.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QAService {
    Page<Question> getAllQuestions(Integer page, Integer pageSize);
    Page<Question> getQuestionsByCategory(Long categoryid, Integer page, Integer pageSize);
    List<Answer> getAnswers(Long questionid);
    Question askQuestion(Long studentid, Question question);
    Answer answerQuestion(Long tutorid, Long questionid, Answer answer);
//    Question resolveQuestion(Question question, Long answerid);
//    Question lockQuestion(Question question);
    Question getQuestion(Long questionid);
    Answer voteAnswer(Long studentid, Answer answer, Question question);
    Posts updatePost(Long tutorid, Posts post);
    Posts closePost(Posts post);
    Page<Posts> getPosts(Integer page, Integer pageSize);
}